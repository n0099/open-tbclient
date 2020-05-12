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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.c;
/* loaded from: classes13.dex */
public class MultiImageTextBottomView extends LinearLayout {
    private com.baidu.adp.lib.b.b idV;
    private TbImageView ifF;
    private int ifG;
    private String ifH;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.idV = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextBottomView.this.idV != null) {
                    MultiImageTextBottomView.this.idV.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    private void initView() {
        setOrientation(0);
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.ifF = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.ifF.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.bottom_title);
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
                            ba.aOV().b(tbPageContext, new String[]{aVar.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "official_msg_ck", "click", 1, "fid", aVar.fid);
                                com.baidu.tieba.im.data.d Fo = com.baidu.tieba.im.util.e.Fo(MultiImageTextBottomView.this.ifH);
                                if (Fo != null) {
                                    TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "message_open_detail", "click", 1, "task_type", Fo.ijp, "task_id", Fo.taskId, "loc", "" + MultiImageTextBottomView.this.ifG);
                                    if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(Fo.taskId)) {
                                        com.baidu.tieba.im.b.a.ciX().Fi(Fo.taskId);
                                    }
                                }
                                an anVar = new an("official_message_open_detail");
                                anVar.t("msg_id", aVar.ifO / 100);
                                anVar.cI("official_id", aVar.ifP);
                                anVar.af("official_type", aVar.ifQ);
                                anVar.t("operate_time", System.currentTimeMillis() / 1000);
                                anVar.t("task_id", aVar.taskId);
                                anVar.cI("obj_params1", aVar.url);
                                TiebaStatic.log(anVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.ifF.setTag(aVar.src);
                this.ifF.startLoad(aVar.src, 10, false);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.ifF.setBackgroundDrawable(null);
        this.ifF.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.idV = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStPosition(int i) {
        this.ifG = i;
    }

    public void setTaskInfo(String str) {
        this.ifH = str;
    }

    public void or(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.ifF.setAutoChangeStyle(z);
        am.setViewTextColor(this.mTitle, R.color.common_color_10039, 1, skinType);
    }
}
