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
    private static final int jkE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View jkF;
    private int jkG;
    private int jkH;
    private boolean jkI;
    private com.baidu.tieba.frs.game.strategy.view.a jkJ;
    private a jkK;
    private int jkL;
    private Drawable jkM;

    /* loaded from: classes22.dex */
    public interface a {
        void l(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jkG = 0;
        this.jkH = 0;
        this.jkI = true;
        this.jkL = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jkG = 0;
        this.jkH = 0;
        this.jkI = true;
        this.jkL = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.jkG = 0;
        this.jkH = 0;
        this.jkI = true;
        this.jkL = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.jkF != null) {
            cP(this.jkF);
        }
        if (this.jkL != 0) {
            this.jkM = ap.getDrawable(i, this.jkL);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.jkG = i;
        this.jkH = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.jkL = i;
        if (this.jkL == 0) {
            this.jkM = ap.getDrawable(i);
        } else {
            this.jkM = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.jkF == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.jkF = frameLayout;
        }
        return this.jkF;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void cP(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.jkI) {
                    imageView.setImageDrawable(ap.getDrawable(this.jkG));
                } else {
                    imageView.setImageDrawable(ap.getDrawable(this.jkH));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean cHx() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (cHx()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.jkJ = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.jkF) {
            if (this.jkJ != null && this.jkJ.cHz()) {
                cHy();
            }
        } else if (this.jkK != null && this.jkJ != null) {
            int AW = this.jkJ.AW(i);
            this.jkJ.AV(AW);
            this.jkK.l(AW, this.jkJ.getItem(i));
        }
    }

    private void cHy() {
        this.jkI = !this.jkI;
        cP(this.jkF);
        if (this.jkJ != null) {
            this.jkJ.qH(this.jkI);
            this.jkJ.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.jkI && this.jkM != null) {
            this.jkM.setBounds(0, (height - jkE) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.jkM.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.jkK = aVar;
    }
}
