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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes20.dex */
public class MultiImageTextTopView extends RelativeLayout {
    private TextView fGU;
    private com.baidu.adp.lib.b.b jfB;
    private TbImageView jhx;
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
        this.jfB = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.jhx = (TbImageView) findViewById(R.id.top_content_pic);
        this.jhx.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.top_title);
        this.fGU = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextTopView.this.jfB != null) {
                    MultiImageTextTopView.this.jfB.onItemViewLongClick(view, 9, MultiImageTextTopView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0719a c0719a, View view, final int i) {
        setPadding((int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30));
        if (c0719a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0719a.title)) {
                str = c0719a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0719a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0719a != null && !StringUtils.isNull(c0719a.url)) {
                            be.bju().b(tbPageContext, new String[]{c0719a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "official_msg_ck", "click", 1, "fid", c0719a.fid);
                                com.baidu.tieba.im.data.d Lg = com.baidu.tieba.im.util.e.Lg(c0719a.jhz);
                                if (Lg != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", "click", 1, "task_type", Lg.jlT, "task_id", Lg.taskId, "loc", "0");
                                    if ((c0719a.userType == 1 || c0719a.userType == 3) && !"0".equals(Lg.taskId)) {
                                        com.baidu.tieba.im.b.a.cIm().La(Lg.taskId);
                                    }
                                }
                                aq aqVar = new aq("official_message_open_detail");
                                aqVar.u("msg_id", c0719a.jwo / 100);
                                aqVar.dD("official_id", c0719a.jwp);
                                aqVar.ai("official_type", c0719a.jwq);
                                aqVar.u("operate_time", System.currentTimeMillis() / 1000);
                                aqVar.u("task_id", c0719a.taskId);
                                aqVar.dD("obj_params1", c0719a.url);
                                TiebaStatic.log(aqVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0719a.src)) {
                this.jhx.setTag(c0719a.src);
                this.jhx.startLoad(c0719a.src, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fGU.setVisibility(8);
            this.fGU.setText("");
            return;
        }
        this.fGU.setVisibility(0);
        this.fGU.setText(str);
    }

    public void reset() {
        this.mTitle.setText("");
        this.jhx.setBackgroundDrawable(null);
        this.jhx.setImageDrawable(null);
        this.fGU.setVisibility(8);
        this.fGU.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jfB = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void qi(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.jhx.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_g, 1, skinType);
        ap.setViewTextColor(this.fGU, R.color.common_color_10067, 1, skinType);
    }
}
