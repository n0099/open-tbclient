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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.officialBar.c;
/* loaded from: classes3.dex */
public class MultiImageTextTopView extends RelativeLayout {
    private TextView cVU;
    private com.baidu.adp.lib.c.b egL;
    private TbImageView eix;
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
        this.egL = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(d.i.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.eix = (TbImageView) findViewById(d.g.top_content_pic);
        this.eix.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(d.g.top_title);
        this.cVU = (TextView) findViewById(d.g.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextTopView.this.egL != null) {
                    MultiImageTextTopView.this.egL.b(view, 9, MultiImageTextTopView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final c.a aVar, View view, final int i) {
        setPadding((int) this.mContext.getResources().getDimension(d.e.ds30), (int) this.mContext.getResources().getDimension(d.e.ds30), (int) this.mContext.getResources().getDimension(d.e.ds30), (int) this.mContext.getResources().getDimension(d.e.ds30));
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
                            az.zV().c(tbPageContext, new String[]{aVar.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, aVar.fid);
                                com.baidu.tieba.im.data.d oP = com.baidu.tieba.im.util.e.oP(aVar.eiz);
                                if (oP != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", "click", 1, "task_type", oP.eml, "task_id", oP.taskId, "loc", "0");
                                    if ((aVar.userType == 1 || aVar.userType == 3) && !"0".equals(oP.taskId)) {
                                        com.baidu.tieba.im.b.a.aMy().oJ(oP.taskId);
                                    }
                                }
                                an anVar = new an("official_message_open_detail");
                                anVar.f("msg_id", aVar.eiG / 100);
                                anVar.ah("official_id", aVar.eiH);
                                anVar.r("official_type", aVar.eiI);
                                anVar.f("operate_time", System.currentTimeMillis() / 1000);
                                anVar.f("task_id", aVar.taskId);
                                anVar.ah("obj_params1", aVar.url);
                                TiebaStatic.log(anVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.src)) {
                this.eix.setTag(aVar.src);
                this.eix.startLoad(aVar.src, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.cVU.setVisibility(8);
            this.cVU.setText("");
            return;
        }
        this.cVU.setVisibility(0);
        this.cVU.setText(str);
    }

    public void reset() {
        this.mTitle.setText("");
        this.eix.setBackgroundDrawable(null);
        this.eix.setImageDrawable(null);
        this.cVU.setVisibility(8);
        this.cVU.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.egL = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void hc(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1 && !z) {
            skinType = 0;
        }
        this.eix.setAutoChangeStyle(z);
        am.b(this.mTitle, d.C0142d.cp_cont_g, 1, skinType);
        am.b(this.cVU, d.C0142d.common_color_10067, 1, skinType);
    }
}
