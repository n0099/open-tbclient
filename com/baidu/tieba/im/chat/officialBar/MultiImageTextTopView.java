package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes8.dex */
public class MultiImageTextTopView extends RelativeLayout {
    private TextView gDo;
    private com.baidu.adp.lib.b.b kAg;
    private TbImageView kCb;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextTopView(Context context) {
        this(context, null);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kAg = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.kCb = (TbImageView) findViewById(R.id.top_content_pic);
        this.kCb.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.top_title);
        this.gDo = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextTopView.this.kAg != null) {
                    MultiImageTextTopView.this.kAg.onItemViewLongClick(view, 9, MultiImageTextTopView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0760a c0760a, View view, final int i) {
        setPadding((int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30));
        if (c0760a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0760a.title)) {
                str = c0760a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0760a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0760a != null && !StringUtils.isNull(c0760a.url)) {
                            bf.bsV().b(tbPageContext, new String[]{c0760a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "official_msg_ck", "click", 1, "fid", c0760a.fid);
                                com.baidu.tieba.im.data.d Nj = com.baidu.tieba.im.util.c.Nj(c0760a.kCd);
                                if (Nj != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", "click", 1, "task_type", Nj.kEC, "task_id", Nj.taskId, "loc", "0");
                                    if ((c0760a.userType == 1 || c0760a.userType == 3) && !"0".equals(Nj.taskId)) {
                                        com.baidu.tieba.im.b.a.cXW().Ne(Nj.taskId);
                                    }
                                }
                                ar arVar = new ar("official_message_open_detail");
                                arVar.v("msg_id", c0760a.kJm / 100);
                                arVar.dR("official_id", c0760a.kJn);
                                arVar.ap("official_type", c0760a.kJo);
                                arVar.v("operate_time", System.currentTimeMillis() / 1000);
                                arVar.v("task_id", c0760a.taskId);
                                arVar.dR("obj_params1", c0760a.url);
                                TiebaStatic.log(arVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0760a.src)) {
                this.kCb.setTag(c0760a.src);
                this.kCb.startLoad(c0760a.src, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gDo.setVisibility(8);
            this.gDo.setText("");
            return;
        }
        this.gDo.setVisibility(0);
        this.gDo.setText(str);
    }

    public void reset() {
        this.mTitle.setText("");
        this.kCb.setBackgroundDrawable(null);
        this.kCb.setImageDrawable(null);
        this.gDo.setVisibility(8);
        this.gDo.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kAg = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void sG(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.kCb.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0111, 1, skinType);
        ap.setViewTextColor(this.gDo, R.color.common_color_10067, 1, skinType);
    }
}
