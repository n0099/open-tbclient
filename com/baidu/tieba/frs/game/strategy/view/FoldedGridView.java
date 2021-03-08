package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, e {
    private static final int jAa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View jAb;
    private int jAc;
    private int jAd;
    private boolean jAe;
    private com.baidu.tieba.frs.game.strategy.view.a jAf;
    private a jAg;
    private int jAh;
    private Drawable jAi;

    /* loaded from: classes2.dex */
    public interface a {
        void l(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jAc = 0;
        this.jAd = 0;
        this.jAe = true;
        this.jAh = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jAc = 0;
        this.jAd = 0;
        this.jAe = true;
        this.jAh = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.jAc = 0;
        this.jAd = 0;
        this.jAe = true;
        this.jAh = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.jAb != null) {
            cX(this.jAb);
        }
        if (this.jAh != 0) {
            this.jAi = ap.getDrawable(i, this.jAh);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.jAc = i;
        this.jAd = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.jAh = i;
        if (this.jAh == 0) {
            this.jAi = ap.getDrawable(i);
        } else {
            this.jAi = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.e
    public View getArrowView() {
        if (this.jAb == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.jAb = frameLayout;
        }
        return this.jAb;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.e
    public void cX(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.jAe) {
                    imageView.setImageDrawable(ap.getDrawable(this.jAc));
                } else {
                    imageView.setImageDrawable(ap.getDrawable(this.jAd));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.e
    public boolean cIg() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.e
    public int getArrowIndex() {
        if (cIg()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.jAf = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.jAb) {
            if (this.jAf != null && this.jAf.cIi()) {
                cIh();
            }
        } else if (this.jAg != null && this.jAf != null) {
            int zN = this.jAf.zN(i);
            this.jAf.zM(zN);
            this.jAg.l(zN, this.jAf.getItem(i));
        }
    }

    private void cIh() {
        this.jAe = !this.jAe;
        cX(this.jAb);
        if (this.jAf != null) {
            this.jAf.rl(this.jAe);
            this.jAf.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.jAe && this.jAi != null) {
            this.jAi.setBounds(0, (height - jAa) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.jAi.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.jAg = aVar;
    }
}
