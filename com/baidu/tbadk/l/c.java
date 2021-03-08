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
    protected TextView bjm;
    private NestedScrollView fIj;
    protected TbImageView fIk;
    protected TBSpecificationBtn fIl;
    private LinearLayout fIm;
    private int fIn;
    private LinearLayout fzw;
    Rect rect;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.fIn = 0;
        this.rect = new Rect();
        this.fIj = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.fzw = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.fIk = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.bjm = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.fIm = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.fIl = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.fIl.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.fIl.setTextSize(R.dimen.tbds42);
        this.fIl.setConfig(aVar);
        this.fIl.setOnClickListener(onClickListener);
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
            this.bjm.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.fIl.setText(str);
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
        this.fIk.setImageResource(0);
    }

    public void showRefreshButton() {
        this.fIl.setVisibility(0);
        this.bjm.setVisibility(0);
        ap.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setImageResource(this.fIk, R.drawable.new_pic_emotion_08);
        ap.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1, skinType);
        ap.setViewTextColor(this.bjm, R.color.CAM_X0107, 1, skinType);
        ap.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
        if (this.fIl != null) {
            this.fIl.bus();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void rn(int i) {
        if (this.fIn <= 0) {
            this.fIn = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.fIj != null) {
            if (i == 0) {
                this.fIj.post(new Runnable() { // from class: com.baidu.tbadk.l.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.rn(-1);
                    }
                });
            }
            if (this.fIj.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.fzw.getTop());
                int abs2 = i2 - Math.abs(this.fzw.getBottom());
                ViewGroup.LayoutParams layoutParams = this.fzw.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.fIn) {
                        marginLayoutParams.topMargin = this.fIn;
                        this.fzw.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.fIn) {
                        if (abs2 > this.fIn) {
                            marginLayoutParams.topMargin = ((abs2 - this.fIn) / 2) + this.fIn;
                            this.fzw.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.fIn) {
                        if (abs2 < this.fIn) {
                            marginLayoutParams.topMargin = this.fIn;
                        } else if (abs2 == this.fIn) {
                            marginLayoutParams.topMargin = this.fIn;
                        } else if (abs2 > this.fIn) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.fzw.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
