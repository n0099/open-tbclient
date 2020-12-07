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
/* loaded from: classes22.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int jkC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View jkD;
    private int jkE;
    private int jkF;
    private boolean jkG;
    private com.baidu.tieba.frs.game.strategy.view.a jkH;
    private a jkI;
    private int jkJ;
    private Drawable jkK;

    /* loaded from: classes22.dex */
    public interface a {
        void l(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jkE = 0;
        this.jkF = 0;
        this.jkG = true;
        this.jkJ = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jkE = 0;
        this.jkF = 0;
        this.jkG = true;
        this.jkJ = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.jkE = 0;
        this.jkF = 0;
        this.jkG = true;
        this.jkJ = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.jkD != null) {
            cP(this.jkD);
        }
        if (this.jkJ != 0) {
            this.jkK = ap.getDrawable(i, this.jkJ);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.jkE = i;
        this.jkF = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.jkJ = i;
        if (this.jkJ == 0) {
            this.jkK = ap.getDrawable(i);
        } else {
            this.jkK = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.jkD == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.jkD = frameLayout;
        }
        return this.jkD;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void cP(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.jkG) {
                    imageView.setImageDrawable(ap.getDrawable(this.jkE));
                } else {
                    imageView.setImageDrawable(ap.getDrawable(this.jkF));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean cHw() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (cHw()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.jkH = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.jkD) {
            if (this.jkH != null && this.jkH.cHy()) {
                cHx();
            }
        } else if (this.jkI != null && this.jkH != null) {
            int AW = this.jkH.AW(i);
            this.jkH.AV(AW);
            this.jkI.l(AW, this.jkH.getItem(i));
        }
    }

    private void cHx() {
        this.jkG = !this.jkG;
        cP(this.jkD);
        if (this.jkH != null) {
            this.jkH.qH(this.jkG);
            this.jkH.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.jkG && this.jkK != null) {
            this.jkK.setBounds(0, (height - jkC) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.jkK.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.jkI = aVar;
    }
}
