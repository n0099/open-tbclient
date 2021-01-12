package com.baidu.tbadk.l;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    protected TextView beC;
    protected TBSpecificationBtn fEA;
    private LinearLayout fEB;
    private int fEC;
    private NestedScrollView fEy;
    protected TbImageView fEz;
    private LinearLayout fvH;
    Rect rect;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.fEC = 0;
        this.rect = new Rect();
        this.fEy = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.fvH = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.fEz = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.beC = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.fEB = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.fEA = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.fEA.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.fEA.setTextSize(R.dimen.tbds42);
        this.fEA.setConfig(aVar);
        this.fEA.setOnClickListener(onClickListener);
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
            this.beC.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.fEA.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.l.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.l.a
    public void onViewDettached() {
        super.onViewDettached();
        this.fEz.setImageResource(0);
    }

    public void showRefreshButton() {
        this.fEA.setVisibility(0);
        this.beC.setVisibility(0);
        ao.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ao.setImageResource(this.fEz, R.drawable.new_pic_emotion_08);
        ao.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1, skinType);
        ao.setViewTextColor(this.beC, R.color.CAM_X0107, 1, skinType);
        ao.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
        if (this.fEA != null) {
            this.fEA.btV();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void rh(int i) {
        if (this.fEC <= 0) {
            this.fEC = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.fEy != null) {
            if (i == 0) {
                this.fEy.post(new Runnable() { // from class: com.baidu.tbadk.l.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.rh(-1);
                    }
                });
            }
            if (this.fEy.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.fvH.getTop());
                int abs2 = i2 - Math.abs(this.fvH.getBottom());
                ViewGroup.LayoutParams layoutParams = this.fvH.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.fEC) {
                        marginLayoutParams.topMargin = this.fEC;
                        this.fvH.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.fEC) {
                        if (abs2 > this.fEC) {
                            marginLayoutParams.topMargin = ((abs2 - this.fEC) / 2) + this.fEC;
                            this.fvH.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.fEC) {
                        if (abs2 < this.fEC) {
                            marginLayoutParams.topMargin = this.fEC;
                        } else if (abs2 == this.fEC) {
                            marginLayoutParams.topMargin = this.fEC;
                        } else if (abs2 > this.fEC) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.fvH.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
