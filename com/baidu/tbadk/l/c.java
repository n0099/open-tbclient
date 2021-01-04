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
    protected TextView bjt;
    private LinearLayout fAp;
    private NestedScrollView fJf;
    protected TbImageView fJg;
    protected TBSpecificationBtn fJh;
    private LinearLayout fJi;
    private int fJj;
    Rect rect;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.fJj = 0;
        this.rect = new Rect();
        this.fJf = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.fAp = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.fJg = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.bjt = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.fJi = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.fJh = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.fJh.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.fJh.setTextSize(R.dimen.tbds42);
        this.fJh.setConfig(aVar);
        this.fJh.setOnClickListener(onClickListener);
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
            this.bjt.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.fJh.setText(str);
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
        this.fJg.setImageResource(0);
    }

    public void showRefreshButton() {
        this.fJh.setVisibility(0);
        this.bjt.setVisibility(0);
        ao.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ao.setImageResource(this.fJg, R.drawable.new_pic_emotion_08);
        ao.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1, skinType);
        ao.setViewTextColor(this.bjt, R.color.CAM_X0107, 1, skinType);
        ao.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
        if (this.fJh != null) {
            this.fJh.bxO();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void sN(int i) {
        if (this.fJj <= 0) {
            this.fJj = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.fJf != null) {
            if (i == 0) {
                this.fJf.post(new Runnable() { // from class: com.baidu.tbadk.l.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.sN(-1);
                    }
                });
            }
            if (this.fJf.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.fAp.getTop());
                int abs2 = i2 - Math.abs(this.fAp.getBottom());
                ViewGroup.LayoutParams layoutParams = this.fAp.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.fJj) {
                        marginLayoutParams.topMargin = this.fJj;
                        this.fAp.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.fJj) {
                        if (abs2 > this.fJj) {
                            marginLayoutParams.topMargin = ((abs2 - this.fJj) / 2) + this.fJj;
                            this.fAp.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.fJj) {
                        if (abs2 < this.fJj) {
                            marginLayoutParams.topMargin = this.fJj;
                        } else if (abs2 == this.fJj) {
                            marginLayoutParams.topMargin = this.fJj;
                        } else if (abs2 > this.fJj) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.fAp.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
