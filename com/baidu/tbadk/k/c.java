package com.baidu.tbadk.k;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    private LinearLayout doQ;
    private NestedScrollView dwH;
    protected TbImageView dwI;
    protected TextView dwJ;
    protected TBSpecificationBtn dwK;
    private LinearLayout dwL;
    private int dwM;
    Rect rect;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.dwM = 0;
        this.rect = new Rect();
        this.dwH = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.doQ = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.dwI = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.dwJ = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.dwL = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.dwK = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.dwK.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.dwK.setTextSize(R.dimen.tbds42);
        this.dwK.setConfig(bVar);
        this.dwK.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.subTextView.setVisibility(8);
            return;
        }
        this.subTextView.setVisibility(0);
        this.subTextView.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.dwJ.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.dwK.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void onViewDettached() {
        super.onViewDettached();
        this.dwI.setImageResource(0);
    }

    public void showRefreshButton() {
        this.dwK.setVisibility(0);
        this.dwJ.setVisibility(0);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.setImageResource(this.dwI, R.drawable.new_pic_emotion_08);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        am.setViewTextColor(this.dwJ, R.color.cp_cont_j, 1, skinType);
        am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.dwK != null) {
            this.dwK.aFd();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void ml(int i) {
        if (this.dwM <= 0) {
            this.dwM = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.dwH != null) {
            if (i == 0) {
                this.dwH.post(new Runnable() { // from class: com.baidu.tbadk.k.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ml(-1);
                    }
                });
            }
            if (this.dwH.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.doQ.getTop());
                int abs2 = i2 - Math.abs(this.doQ.getBottom());
                ViewGroup.LayoutParams layoutParams = this.doQ.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.dwM) {
                        marginLayoutParams.topMargin = this.dwM;
                        this.doQ.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.dwM) {
                        if (abs2 > this.dwM) {
                            marginLayoutParams.topMargin = ((abs2 - this.dwM) / 2) + this.dwM;
                            this.doQ.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.dwM) {
                        if (abs2 < this.dwM) {
                            marginLayoutParams.topMargin = this.dwM;
                        } else if (abs2 == this.dwM) {
                            marginLayoutParams.topMargin = this.dwM;
                        } else if (abs2 > this.dwM) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.doQ.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
