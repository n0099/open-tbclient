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
/* loaded from: classes8.dex */
public class MultiImageTextBottomView extends LinearLayout {
    private com.baidu.adp.lib.b.b kAu;
    private TbImageView kCp;
    private int kCq;
    private String kCr;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kAu = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextBottomView.this.kAu != null) {
                    MultiImageTextBottomView.this.kAu.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    private void initView() {
        setOrientation(0);
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.kCp = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.kCp.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.bottom_title);
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0761a c0761a, View view, final int i) {
        if (c0761a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0761a.title)) {
                str = c0761a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0761a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0761a != null && !StringUtils.isNull(c0761a.url)) {
                            bf.bsV().b(tbPageContext, new String[]{c0761a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "official_msg_ck", "click", 1, "fid", c0761a.fid);
                                com.baidu.tieba.im.data.d Nk = com.baidu.tieba.im.util.c.Nk(MultiImageTextBottomView.this.kCr);
                                if (Nk != null) {
                                    TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "message_open_detail", "click", 1, "task_type", Nk.kEQ, "task_id", Nk.taskId, "loc", "" + MultiImageTextBottomView.this.kCq);
                                    if ((c0761a.userType == 1 || c0761a.userType == 3) && !"0".equals(Nk.taskId)) {
                                        com.baidu.tieba.im.b.a.cYd().Nf(Nk.taskId);
                                    }
                                }
                                ar arVar = new ar("official_message_open_detail");
                                arVar.v("msg_id", c0761a.kJA / 100);
                                arVar.dR("official_id", c0761a.kJB);
                                arVar.ap("official_type", c0761a.kJC);
                                arVar.v("operate_time", System.currentTimeMillis() / 1000);
                                arVar.v("task_id", c0761a.taskId);
                                arVar.dR("obj_params1", c0761a.url);
                                TiebaStatic.log(arVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0761a.src)) {
                this.kCp.setTag(c0761a.src);
                this.kCp.startLoad(c0761a.src, 10, false);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.kCp.setBackgroundDrawable(null);
        this.kCp.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.kAu = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStPosition(int i) {
        this.kCq = i;
    }

    public void setTaskInfo(String str) {
        this.kCr = str;
    }

    public void sG(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.kCp.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.common_color_10039, 1, skinType);
    }
}
