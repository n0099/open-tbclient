package com.baidu.tieba.frs;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FrsNoListItemViewHolder extends TypeAdapter.ViewHolder {
    public static BdUniqueId jlE = BdUniqueId.gen();
    private int fIn;
    private LinearLayout fzw;
    public TextView jlF;
    public ImageView jlG;
    private int jlH;
    private CustomMessageListener jlI;
    private ViewGroup mParent;
    private View mRootView;
    private Rect rect;

    public FrsNoListItemViewHolder(View view, ViewGroup viewGroup) {
        super(view);
        this.rect = new Rect();
        this.jlI = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.FrsNoListItemViewHolder.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    FrsNoListItemViewHolder.this.rn(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.fzw = (LinearLayout) view.findViewById(R.id.container);
        this.jlG = (ImageView) view.findViewById(R.id.emotion_view);
        this.jlF = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.ap.setImageResource(this.jlG, R.drawable.new_pic_emotion_06);
        this.jlI.setTag(jlE);
        MessageManager.getInstance().registerListener(this.jlI);
        cEy();
    }

    private void cEy() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.FrsNoListItemViewHolder.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (FrsNoListItemViewHolder.this.cT(view)) {
                        FrsNoListItemViewHolder.this.rn(Integer.MAX_VALUE);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cT(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rn(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.fIn <= 0) {
                this.fIn = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.jlH != Integer.MAX_VALUE) {
                this.jlH = i;
                if (this.mParent.getLocalVisibleRect(this.rect)) {
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
}
