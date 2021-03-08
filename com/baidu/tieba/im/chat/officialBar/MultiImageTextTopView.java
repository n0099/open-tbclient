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
/* loaded from: classes7.dex */
public class MultiImageTextTopView extends RelativeLayout {
    private TextView gFl;
    private com.baidu.adp.lib.b.b kCw;
    private TbImageView kEr;
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
        this.kCw = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.kEr = (TbImageView) findViewById(R.id.top_content_pic);
        this.kEr.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.top_title);
        this.gFl = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextTopView.this.kCw != null) {
                    MultiImageTextTopView.this.kCw.onItemViewLongClick(view, 9, MultiImageTextTopView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0767a c0767a, View view, final int i) {
        setPadding((int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30));
        if (c0767a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0767a.title)) {
                str = c0767a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0767a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0767a != null && !StringUtils.isNull(c0767a.url)) {
                            bf.bsY().b(tbPageContext, new String[]{c0767a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "official_msg_ck", "click", 1, "fid", c0767a.fid);
                                com.baidu.tieba.im.data.d Nq = com.baidu.tieba.im.util.c.Nq(c0767a.kEt);
                                if (Nq != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", "click", 1, "task_type", Nq.kGS, "task_id", Nq.taskId, "loc", "0");
                                    if ((c0767a.userType == 1 || c0767a.userType == 3) && !"0".equals(Nq.taskId)) {
                                        com.baidu.tieba.im.b.a.cYk().Nl(Nq.taskId);
                                    }
                                }
                                ar arVar = new ar("official_message_open_detail");
                                arVar.v("msg_id", c0767a.kLC / 100);
                                arVar.dR("official_id", c0767a.kLD);
                                arVar.aq("official_type", c0767a.kLE);
                                arVar.v("operate_time", System.currentTimeMillis() / 1000);
                                arVar.v("task_id", c0767a.taskId);
                                arVar.dR("obj_params1", c0767a.url);
                                TiebaStatic.log(arVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0767a.src)) {
                this.kEr.setTag(c0767a.src);
                this.kEr.startLoad(c0767a.src, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gFl.setVisibility(8);
            this.gFl.setText("");
            return;
        }
        this.gFl.setVisibility(0);
        this.gFl.setText(str);
    }

    public void reset() {
        this.mTitle.setText("");
        this.kEr.setBackgroundDrawable(null);
        this.kEr.setImageDrawable(null);
        this.gFl.setVisibility(8);
        this.gFl.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kCw = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void sG(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.kEr.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0111, 1, skinType);
        ap.setViewTextColor(this.gFl, R.color.common_color_10067, 1, skinType);
    }
}
