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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int dWx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds48);
    private int dWA;
    private boolean dWB;
    private com.baidu.tieba.frs.game.strategy.view.a dWC;
    private a dWD;
    private int dWE;
    private Drawable dWF;
    private View dWy;
    private int dWz;

    /* loaded from: classes3.dex */
    public interface a {
        void c(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dWz = 0;
        this.dWA = 0;
        this.dWB = true;
        this.dWE = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dWz = 0;
        this.dWA = 0;
        this.dWB = true;
        this.dWE = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.dWz = 0;
        this.dWA = 0;
        this.dWB = true;
        this.dWE = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.dWy != null) {
            aR(this.dWy);
        }
        if (this.dWE != 0) {
            this.dWF = al.y(i, this.dWE);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.dWz = i;
        this.dWA = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.dWE = i;
        if (this.dWE == 0) {
            this.dWF = al.getDrawable(i);
        } else {
            this.dWF = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.dWy == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.dWy = frameLayout;
        }
        return this.dWy;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void aR(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.dWB) {
                    imageView.setImageDrawable(al.getDrawable(this.dWz));
                } else {
                    imageView.setImageDrawable(al.getDrawable(this.dWA));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean aFt() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (aFt()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.dWC = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.dWy) {
            if (this.dWC != null && this.dWC.aFv()) {
                aFu();
            }
        } else if (this.dWD != null && this.dWC != null) {
            int mZ = this.dWC.mZ(i);
            this.dWC.mY(mZ);
            this.dWD.c(mZ, this.dWC.getItem(i));
        }
    }

    private void aFu() {
        this.dWB = !this.dWB;
        aR(this.dWy);
        if (this.dWC != null) {
            this.dWC.hg(this.dWB);
            this.dWC.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.dWB && this.dWF != null) {
            this.dWF.setBounds(0, (height - dWx) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.dWF.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.dWD = aVar;
    }
}
