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
/* loaded from: classes26.dex */
public class MultiImageTextTopView extends RelativeLayout {
    private TextView ggF;
    private com.baidu.adp.lib.b.b jPJ;
    private TbImageView jRF;
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
        this.jPJ = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.jRF = (TbImageView) findViewById(R.id.top_content_pic);
        this.jRF.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.top_title);
        this.ggF = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextTopView.this.jPJ != null) {
                    MultiImageTextTopView.this.jPJ.onItemViewLongClick(view, 9, MultiImageTextTopView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0750a c0750a, View view, final int i) {
        setPadding((int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30));
        if (c0750a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0750a.title)) {
                str = c0750a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0750a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0750a != null && !StringUtils.isNull(c0750a.url)) {
                            be.boR().b(tbPageContext, new String[]{c0750a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "official_msg_ck", "click", 1, "fid", c0750a.fid);
                                com.baidu.tieba.im.data.d MW = com.baidu.tieba.im.util.e.MW(c0750a.jRH);
                                if (MW != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", "click", 1, "task_type", MW.jVZ, "task_id", MW.taskId, "loc", "0");
                                    if ((c0750a.userType == 1 || c0750a.userType == 3) && !"0".equals(MW.taskId)) {
                                        com.baidu.tieba.im.b.a.cSI().MQ(MW.taskId);
                                    }
                                }
                                aq aqVar = new aq("official_message_open_detail");
                                aqVar.w("msg_id", c0750a.kgt / 100);
                                aqVar.dR("official_id", c0750a.kgu);
                                aqVar.aj("official_type", c0750a.kgv);
                                aqVar.w("operate_time", System.currentTimeMillis() / 1000);
                                aqVar.w("task_id", c0750a.taskId);
                                aqVar.dR("obj_params1", c0750a.url);
                                TiebaStatic.log(aqVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0750a.src)) {
                this.jRF.setTag(c0750a.src);
                this.jRF.startLoad(c0750a.src, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ggF.setVisibility(8);
            this.ggF.setText("");
            return;
        }
        this.ggF.setVisibility(0);
        this.ggF.setText(str);
    }

    public void reset() {
        this.mTitle.setText("");
        this.jRF.setBackgroundDrawable(null);
        this.jRF.setImageDrawable(null);
        this.ggF.setVisibility(8);
        this.ggF.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jPJ = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void rq(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.jRF.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_g, 1, skinType);
        ap.setViewTextColor(this.ggF, R.color.common_color_10067, 1, skinType);
    }
}
