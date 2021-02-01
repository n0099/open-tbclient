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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    protected TextView bhK;
    private NestedScrollView fGK;
    protected TbImageView fGL;
    protected TBSpecificationBtn fGM;
    private LinearLayout fGN;
    private int fGO;
    private LinearLayout fxX;
    Rect rect;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.fGO = 0;
        this.rect = new Rect();
        this.fGK = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.fxX = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.fGL = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.bhK = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.fGN = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.fGM = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.fGM.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.fGM.setTextSize(R.dimen.tbds42);
        this.fGM.setConfig(aVar);
        this.fGM.setOnClickListener(onClickListener);
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
            this.bhK.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.fGM.setText(str);
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
        this.fGL.setImageResource(0);
    }

    public void showRefreshButton() {
        this.fGM.setVisibility(0);
        this.bhK.setVisibility(0);
        ap.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setImageResource(this.fGL, R.drawable.new_pic_emotion_08);
        ap.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1, skinType);
        ap.setViewTextColor(this.bhK, R.color.CAM_X0107, 1, skinType);
        ap.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
        if (this.fGM != null) {
            this.fGM.bup();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void rm(int i) {
        if (this.fGO <= 0) {
            this.fGO = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.fGK != null) {
            if (i == 0) {
                this.fGK.post(new Runnable() { // from class: com.baidu.tbadk.l.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.rm(-1);
                    }
                });
            }
            if (this.fGK.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.fxX.getTop());
                int abs2 = i2 - Math.abs(this.fxX.getBottom());
                ViewGroup.LayoutParams layoutParams = this.fxX.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.fGO) {
                        marginLayoutParams.topMargin = this.fGO;
                        this.fxX.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.fGO) {
                        if (abs2 > this.fGO) {
                            marginLayoutParams.topMargin = ((abs2 - this.fGO) / 2) + this.fGO;
                            this.fxX.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.fGO) {
                        if (abs2 < this.fGO) {
                            marginLayoutParams.topMargin = this.fGO;
                        } else if (abs2 == this.fGO) {
                            marginLayoutParams.topMargin = this.fGO;
                        } else if (abs2 > this.fGO) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.fxX.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
