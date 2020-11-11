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
    private com.baidu.adp.lib.b.b jVG;
    private TbImageView jXC;
    private int jXD;
    private String jXE;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jVG = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextBottomView.this.jVG != null) {
                    MultiImageTextBottomView.this.jVG.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    private void initView() {
        setOrientation(0);
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.jXC = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.jXC.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.bottom_title);
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0764a c0764a, View view, final int i) {
        if (c0764a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0764a.title)) {
                str = c0764a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0764a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0764a != null && !StringUtils.isNull(c0764a.url)) {
                            be.brr().b(tbPageContext, new String[]{c0764a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "official_msg_ck", "click", 1, "fid", c0764a.fid);
                                com.baidu.tieba.im.data.d Nn = com.baidu.tieba.im.util.e.Nn(MultiImageTextBottomView.this.jXE);
                                if (Nn != null) {
                                    TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "message_open_detail", "click", 1, "task_type", Nn.kbW, "task_id", Nn.taskId, "loc", "" + MultiImageTextBottomView.this.jXD);
                                    if ((c0764a.userType == 1 || c0764a.userType == 3) && !"0".equals(Nn.taskId)) {
                                        com.baidu.tieba.im.b.a.cVj().Nh(Nn.taskId);
                                    }
                                }
                                aq aqVar = new aq("official_message_open_detail");
                                aqVar.w("msg_id", c0764a.kmq / 100);
                                aqVar.dR("official_id", c0764a.kmr);
                                aqVar.al("official_type", c0764a.kms);
                                aqVar.w("operate_time", System.currentTimeMillis() / 1000);
                                aqVar.w("task_id", c0764a.taskId);
                                aqVar.dR("obj_params1", c0764a.url);
                                TiebaStatic.log(aqVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0764a.src)) {
                this.jXC.setTag(c0764a.src);
                this.jXC.startLoad(c0764a.src, 10, false);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.jXC.setBackgroundDrawable(null);
        this.jXC.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jVG = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStPosition(int i) {
        this.jXD = i;
    }

    public void setTaskInfo(String str) {
        this.jXE = str;
    }

    public void rz(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.jXC.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.common_color_10039, 1, skinType);
    }
}
