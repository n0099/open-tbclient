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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.im.chat.officialBar.c;
/* loaded from: classes3.dex */
public class MultiImageTextBottomView extends LinearLayout {
    private com.baidu.adp.lib.c.b ekx;
    private TbImageView emk;
    private int eml;
    private String emm;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ekx = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextBottomView.this.ekx != null) {
                    MultiImageTextBottomView.this.ekx.b(view, 9, MultiImageTextBottomView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    private void initView() {
        setOrientation(0);
        LayoutInflater.from(this.mContext).inflate(f.h.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.emk = (TbImageView) findViewById(f.g.bottom_content_pic);
        this.emk.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(f.g.bottom_title);
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
                            az.zI().c(tbPageContext, new String[]{aVar.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                                com.baidu.tieba.im.data.d oT = com.baidu.tieba.im.util.e.oT(MultiImageTextBottomView.this.emm);
                                if (oT != null) {
                                    TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "message_open_detail", "click", 1, "task_type", oT.eqa, "task_id", oT.taskId, "loc", "" + MultiImageTextBottomView.this.eml);
                                    if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(oT.taskId)) {
                                        com.baidu.tieba.im.b.a.aNv().oN(oT.taskId);
                                    }
                                }
                                an anVar = new an("official_message_open_detail");
                                anVar.f("msg_id", aVar.emt / 100);
                                anVar.ae("official_id", aVar.emu);
                                anVar.r("official_type", aVar.emv);
                                anVar.f("operate_time", System.currentTimeMillis() / 1000);
                                anVar.f("task_id", aVar.taskId);
                                anVar.ae("obj_params1", aVar.url);
                                TiebaStatic.log(anVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.emk.setTag(aVar.src);
                this.emk.startLoad(aVar.src, 10, false);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.emk.setBackgroundDrawable(null);
        this.emk.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.ekx = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStPosition(int i) {
        this.eml = i;
    }

    public void setTaskInfo(String str) {
        this.emm = str;
    }

    public void hf(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.emk.setAutoChangeStyle(z);
        am.b(this.mTitle, f.d.common_color_10039, 1, skinType);
    }
}
