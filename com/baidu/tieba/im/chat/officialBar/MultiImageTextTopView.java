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
    private TextView fGY;
    private com.baidu.adp.lib.b.b jfH;
    private TbImageView jhD;
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
        this.jfH = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.jhD = (TbImageView) findViewById(R.id.top_content_pic);
        this.jhD.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.top_title);
        this.fGY = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextTopView.this.jfH != null) {
                    MultiImageTextTopView.this.jfH.onItemViewLongClick(view, 9, MultiImageTextTopView.this.mPosition, 0L);
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
                                com.baidu.tieba.im.data.d Lh = com.baidu.tieba.im.util.e.Lh(c0719a.jhF);
                                if (Lh != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", "click", 1, "task_type", Lh.jlZ, "task_id", Lh.taskId, "loc", "0");
                                    if ((c0719a.userType == 1 || c0719a.userType == 3) && !"0".equals(Lh.taskId)) {
                                        com.baidu.tieba.im.b.a.cIn().Lb(Lh.taskId);
                                    }
                                }
                                aq aqVar = new aq("official_message_open_detail");
                                aqVar.u("msg_id", c0719a.jwu / 100);
                                aqVar.dD("official_id", c0719a.jwv);
                                aqVar.ai("official_type", c0719a.jww);
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
                this.jhD.setTag(c0719a.src);
                this.jhD.startLoad(c0719a.src, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fGY.setVisibility(8);
            this.fGY.setText("");
            return;
        }
        this.fGY.setVisibility(0);
        this.fGY.setText(str);
    }

    public void reset() {
        this.mTitle.setText("");
        this.jhD.setBackgroundDrawable(null);
        this.jhD.setImageDrawable(null);
        this.fGY.setVisibility(8);
        this.fGY.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jfH = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void qk(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.jhD.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_g, 1, skinType);
        ap.setViewTextColor(this.fGY, R.color.common_color_10067, 1, skinType);
    }
}
