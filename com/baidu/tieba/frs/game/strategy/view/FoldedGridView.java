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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int drx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private int drA;
    private boolean drB;
    private com.baidu.tieba.frs.game.strategy.view.a drC;
    private a drD;
    private int drE;
    private Drawable drF;
    private View dry;
    private int drz;

    /* loaded from: classes3.dex */
    public interface a {
        void c(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drz = 0;
        this.drA = 0;
        this.drB = true;
        this.drE = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drz = 0;
        this.drA = 0;
        this.drB = true;
        this.drE = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.drz = 0;
        this.drA = 0;
        this.drB = true;
        this.drE = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.dry != null) {
            at(this.dry);
        }
        if (this.drE != 0) {
            this.drF = al.v(i, this.drE);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.drz = i;
        this.drA = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.drE = i;
        if (this.drE == 0) {
            this.drF = al.getDrawable(i);
        } else {
            this.drF = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.dry == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.dry = frameLayout;
        }
        return this.dry;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void at(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.drB) {
                    imageView.setImageDrawable(al.getDrawable(this.drz));
                } else {
                    imageView.setImageDrawable(al.getDrawable(this.drA));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean awI() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (awI()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.drC = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.dry) {
            if (this.drC != null && this.drC.awK()) {
                awJ();
            }
        } else if (this.drD != null && this.drC != null) {
            int kN = this.drC.kN(i);
            this.drC.kM(kN);
            this.drD.c(kN, this.drC.getItem(i));
        }
    }

    private void awJ() {
        this.drB = !this.drB;
        at(this.dry);
        if (this.drC != null) {
            this.drC.fS(this.drB);
            this.drC.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.drB && this.drF != null) {
            this.drF.setBounds(0, (height - drx) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.drF.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.drD = aVar;
    }
}
