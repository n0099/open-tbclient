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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.officialBar.c;
/* loaded from: classes3.dex */
public class MultiImageTextBottomView extends LinearLayout {
    private com.baidu.adp.lib.c.b ecR;
    private TbImageView eeD;
    private int eeE;
    private String eeF;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ecR = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextBottomView.this.ecR != null) {
                    MultiImageTextBottomView.this.ecR.b(view, 9, MultiImageTextBottomView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    private void initView() {
        setOrientation(0);
        LayoutInflater.from(this.mContext).inflate(d.i.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.eeD = (TbImageView) findViewById(d.g.bottom_content_pic);
        this.eeD.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(d.g.bottom_title);
    }

    public void setData(final TbPageContext<?> tbPageContext, final c.a aVar, View view, final int i) {
        if (aVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(aVar.title)) {
                str = aVar.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(aVar.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (aVar != null && !StringUtils.isNull(aVar.url)) {
                            ay.zG().c(tbPageContext, new String[]{aVar.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                                com.baidu.tieba.im.data.d oO = com.baidu.tieba.im.util.e.oO(MultiImageTextBottomView.this.eeF);
                                if (oO != null) {
                                    TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "message_open_detail", "click", 1, "task_type", oO.eis, "task_id", oO.taskId, "loc", "" + MultiImageTextBottomView.this.eeE);
                                    if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(oO.taskId)) {
                                        com.baidu.tieba.im.b.a.aLS().oI(oO.taskId);
                                    }
                                }
                                am amVar = new am("official_message_open_detail");
                                amVar.f("msg_id", aVar.eeM / 100);
                                amVar.ah("official_id", aVar.eeN);
                                amVar.r("official_type", aVar.eeO);
                                amVar.f("operate_time", System.currentTimeMillis() / 1000);
                                amVar.f("task_id", aVar.taskId);
                                amVar.ah("obj_params1", aVar.url);
                                TiebaStatic.log(amVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.eeD.setTag(aVar.src);
                this.eeD.startLoad(aVar.src, 10, false);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.eeD.setBackgroundDrawable(null);
        this.eeD.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.ecR = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStPosition(int i) {
        this.eeE = i;
    }

    public void setTaskInfo(String str) {
        this.eeF = str;
    }

    public void gS(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.eeD.setAutoChangeStyle(z);
        al.b(this.mTitle, d.C0141d.common_color_10039, 1, skinType);
    }
}
