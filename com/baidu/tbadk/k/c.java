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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    protected TextView aZl;
    Rect bry;
    private LinearLayout eJG;
    private NestedScrollView eSd;
    protected TbImageView eSe;
    protected TBSpecificationBtn eSf;
    private LinearLayout eSg;
    private int eSh;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.eSh = 0;
        this.bry = new Rect();
        this.eSd = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.eJG = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.eSe = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.aZl = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.eSg = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.eSf = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.eSf.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.eSf.setTextSize(R.dimen.tbds42);
        this.eSf.setConfig(aVar);
        this.eSf.setOnClickListener(onClickListener);
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
            this.aZl.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.eSf.setText(str);
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
        this.eSe.setImageResource(0);
    }

    public void showRefreshButton() {
        this.eSf.setVisibility(0);
        this.aZl.setVisibility(0);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setImageResource(this.eSe, R.drawable.new_pic_emotion_08);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        ap.setViewTextColor(this.aZl, R.color.cp_cont_j, 1, skinType);
        ap.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.eSf != null) {
            this.eSf.blA();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void qJ(int i) {
        if (this.eSh <= 0) {
            this.eSh = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.eSd != null) {
            if (i == 0) {
                this.eSd.post(new Runnable() { // from class: com.baidu.tbadk.k.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.qJ(-1);
                    }
                });
            }
            if (this.eSd.getLocalVisibleRect(this.bry)) {
                int i2 = this.bry.bottom;
                int abs = Math.abs(this.eJG.getTop());
                int abs2 = i2 - Math.abs(this.eJG.getBottom());
                ViewGroup.LayoutParams layoutParams = this.eJG.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.eSh) {
                        marginLayoutParams.topMargin = this.eSh;
                        this.eJG.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.eSh) {
                        if (abs2 > this.eSh) {
                            marginLayoutParams.topMargin = ((abs2 - this.eSh) / 2) + this.eSh;
                            this.eJG.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.eSh) {
                        if (abs2 < this.eSh) {
                            marginLayoutParams.topMargin = this.eSh;
                        } else if (abs2 == this.eSh) {
                            marginLayoutParams.topMargin = this.eSh;
                        } else if (abs2 > this.eSh) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.eJG.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
