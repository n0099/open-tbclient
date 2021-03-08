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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes7.dex */
public class MultiImageTextBottomView extends LinearLayout {
    private com.baidu.adp.lib.b.b kCw;
    private TbImageView kEr;
    private int kEs;
    private String kEt;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kCw = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextBottomView.this.kCw != null) {
                    MultiImageTextBottomView.this.kCw.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    private void initView() {
        setOrientation(0);
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.kEr = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.kEr.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.bottom_title);
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0767a c0767a, View view, final int i) {
        if (c0767a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0767a.title)) {
                str = c0767a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0767a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0767a != null && !StringUtils.isNull(c0767a.url)) {
                            bf.bsY().b(tbPageContext, new String[]{c0767a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "official_msg_ck", "click", 1, "fid", c0767a.fid);
                                com.baidu.tieba.im.data.d Nq = com.baidu.tieba.im.util.c.Nq(MultiImageTextBottomView.this.kEt);
                                if (Nq != null) {
                                    TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "message_open_detail", "click", 1, "task_type", Nq.kGS, "task_id", Nq.taskId, "loc", "" + MultiImageTextBottomView.this.kEs);
                                    if ((c0767a.userType == 1 || c0767a.userType == 3) && !"0".equals(Nq.taskId)) {
                                        com.baidu.tieba.im.b.a.cYk().Nl(Nq.taskId);
                                    }
                                }
                                ar arVar = new ar("official_message_open_detail");
                                arVar.v("msg_id", c0767a.kLC / 100);
                                arVar.dR("official_id", c0767a.kLD);
                                arVar.aq("official_type", c0767a.kLE);
                                arVar.v("operate_time", System.currentTimeMillis() / 1000);
                                arVar.v("task_id", c0767a.taskId);
                                arVar.dR("obj_params1", c0767a.url);
                                TiebaStatic.log(arVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0767a.src)) {
                this.kEr.setTag(c0767a.src);
                this.kEr.startLoad(c0767a.src, 10, false);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.kEr.setBackgroundDrawable(null);
        this.kEr.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kCw = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStPosition(int i) {
        this.kEs = i;
    }

    public void setTaskInfo(String str) {
        this.kEt = str;
    }

    public void sG(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.kEr.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.common_color_10039, 1, skinType);
    }
}
