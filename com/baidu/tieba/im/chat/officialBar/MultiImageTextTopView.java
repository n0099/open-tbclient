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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.officialBar.c;
/* loaded from: classes3.dex */
public class MultiImageTextTopView extends RelativeLayout {
    private TextView dmH;
    private TbImageView eBu;
    private com.baidu.adp.lib.c.b ezH;
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
        this.ezH = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(e.h.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.eBu = (TbImageView) findViewById(e.g.top_content_pic);
        this.eBu.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(e.g.top_title);
        this.dmH = (TextView) findViewById(e.g.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextTopView.this.ezH != null) {
                    MultiImageTextTopView.this.ezH.b(view, 9, MultiImageTextTopView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final c.a aVar, View view, final int i) {
        setPadding((int) this.mContext.getResources().getDimension(e.C0175e.ds30), (int) this.mContext.getResources().getDimension(e.C0175e.ds30), (int) this.mContext.getResources().getDimension(e.C0175e.ds30), (int) this.mContext.getResources().getDimension(e.C0175e.ds30));
        if (aVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(aVar.title)) {
                str = aVar.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (aVar != null && !StringUtils.isNull(aVar.url)) {
                            ay.CU().c(tbPageContext, new String[]{aVar.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "official_msg_ck", AiAppsUBCStatistic.TYPE_CLICK, 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                                com.baidu.tieba.im.data.d qa = com.baidu.tieba.im.util.e.qa(aVar.eBw);
                                if (qa != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", AiAppsUBCStatistic.TYPE_CLICK, 1, "task_type", qa.eFh, "task_id", qa.taskId, "loc", "0");
                                    if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(qa.taskId)) {
                                        com.baidu.tieba.im.b.a.aSY().pU(qa.taskId);
                                    }
                                }
                                am amVar = new am("official_message_open_detail");
                                amVar.h("msg_id", aVar.eBD / 100);
                                amVar.ax("official_id", aVar.eBE);
                                amVar.x("official_type", aVar.eBF);
                                amVar.h("operate_time", System.currentTimeMillis() / 1000);
                                amVar.h("task_id", aVar.taskId);
                                amVar.ax("obj_params1", aVar.url);
                                TiebaStatic.log(amVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.eBu.setTag(aVar.src);
                this.eBu.startLoad(aVar.src, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.dmH.setVisibility(8);
            this.dmH.setText("");
            return;
        }
        this.dmH.setVisibility(0);
        this.dmH.setText(str);
    }

    public void reset() {
        this.mTitle.setText("");
        this.eBu.setBackgroundDrawable(null);
        this.eBu.setImageDrawable(null);
        this.dmH.setVisibility(8);
        this.dmH.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.ezH = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void hV(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.eBu.setAutoChangeStyle(z);
        al.b(this.mTitle, e.d.cp_cont_g, 1, skinType);
        al.b(this.dmH, e.d.common_color_10067, 1, skinType);
    }
}
