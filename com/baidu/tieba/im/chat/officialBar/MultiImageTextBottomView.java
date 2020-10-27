package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
public class MultiImageTextBottomView extends LinearLayout {
    private com.baidu.adp.lib.b.b jPJ;
    private TbImageView jRF;
    private int jRG;
    private String jRH;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jPJ = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextBottomView.this.jPJ != null) {
                    MultiImageTextBottomView.this.jPJ.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    private void initView() {
        setOrientation(0);
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.jRF = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.jRF.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.bottom_title);
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0750a c0750a, View view, final int i) {
        if (c0750a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0750a.title)) {
                str = c0750a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0750a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0750a != null && !StringUtils.isNull(c0750a.url)) {
                            be.boR().b(tbPageContext, new String[]{c0750a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "official_msg_ck", "click", 1, "fid", c0750a.fid);
                                com.baidu.tieba.im.data.d MW = com.baidu.tieba.im.util.e.MW(MultiImageTextBottomView.this.jRH);
                                if (MW != null) {
                                    TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "message_open_detail", "click", 1, "task_type", MW.jVZ, "task_id", MW.taskId, "loc", "" + MultiImageTextBottomView.this.jRG);
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

    public void reset() {
        this.mTitle.setText("");
        this.jRF.setBackgroundDrawable(null);
        this.jRF.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jPJ = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStPosition(int i) {
        this.jRG = i;
    }

    public void setTaskInfo(String str) {
        this.jRH = str;
    }

    public void rq(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.jRF.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.common_color_10039, 1, skinType);
    }
}
