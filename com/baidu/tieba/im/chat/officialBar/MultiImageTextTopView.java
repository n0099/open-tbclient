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
    private TextView gDC;
    private com.baidu.adp.lib.b.b kAu;
    private TbImageView kCp;
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
        this.kAu = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.kCp = (TbImageView) findViewById(R.id.top_content_pic);
        this.kCp.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.top_title);
        this.gDC = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextTopView.this.kAu != null) {
                    MultiImageTextTopView.this.kAu.onItemViewLongClick(view, 9, MultiImageTextTopView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0761a c0761a, View view, final int i) {
        setPadding((int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30));
        if (c0761a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0761a.title)) {
                str = c0761a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0761a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0761a != null && !StringUtils.isNull(c0761a.url)) {
                            bf.bsV().b(tbPageContext, new String[]{c0761a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "official_msg_ck", "click", 1, "fid", c0761a.fid);
                                com.baidu.tieba.im.data.d Nk = com.baidu.tieba.im.util.c.Nk(c0761a.kCr);
                                if (Nk != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", "click", 1, "task_type", Nk.kEQ, "task_id", Nk.taskId, "loc", "0");
                                    if ((c0761a.userType == 1 || c0761a.userType == 3) && !"0".equals(Nk.taskId)) {
                                        com.baidu.tieba.im.b.a.cYd().Nf(Nk.taskId);
                                    }
                                }
                                ar arVar = new ar("official_message_open_detail");
                                arVar.v("msg_id", c0761a.kJA / 100);
                                arVar.dR("official_id", c0761a.kJB);
                                arVar.ap("official_type", c0761a.kJC);
                                arVar.v("operate_time", System.currentTimeMillis() / 1000);
                                arVar.v("task_id", c0761a.taskId);
                                arVar.dR("obj_params1", c0761a.url);
                                TiebaStatic.log(arVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0761a.src)) {
                this.kCp.setTag(c0761a.src);
                this.kCp.startLoad(c0761a.src, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gDC.setVisibility(8);
            this.gDC.setText("");
            return;
        }
        this.gDC.setVisibility(0);
        this.gDC.setText(str);
    }

    public void reset() {
        this.mTitle.setText("");
        this.kCp.setBackgroundDrawable(null);
        this.kCp.setImageDrawable(null);
        this.gDC.setVisibility(8);
        this.gDC.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kAu = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void sG(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.kCp.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0111, 1, skinType);
        ap.setViewTextColor(this.gDC, R.color.common_color_10067, 1, skinType);
    }
}
