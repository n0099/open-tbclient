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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int fGA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View fGB;
    private int fGC;
    private int fGD;
    private boolean fGE;
    private com.baidu.tieba.frs.game.strategy.view.a fGF;
    private a fGG;
    private int fGH;
    private Drawable fGI;

    /* loaded from: classes4.dex */
    public interface a {
        void f(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fGC = 0;
        this.fGD = 0;
        this.fGE = true;
        this.fGH = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fGC = 0;
        this.fGD = 0;
        this.fGE = true;
        this.fGH = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.fGC = 0;
        this.fGD = 0;
        this.fGE = true;
        this.fGH = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.fGB != null) {
            bU(this.fGB);
        }
        if (this.fGH != 0) {
            this.fGI = am.V(i, this.fGH);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.fGC = i;
        this.fGD = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.fGH = i;
        if (this.fGH == 0) {
            this.fGI = am.getDrawable(i);
        } else {
            this.fGI = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.fGB == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.fGB = frameLayout;
        }
        return this.fGB;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void bU(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.fGE) {
                    imageView.setImageDrawable(am.getDrawable(this.fGC));
                } else {
                    imageView.setImageDrawable(am.getDrawable(this.fGD));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean bpO() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (bpO()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.fGF = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.fGB) {
            if (this.fGF != null && this.fGF.bpQ()) {
                bpP();
            }
        } else if (this.fGG != null && this.fGF != null) {
            int sl = this.fGF.sl(i);
            this.fGF.sk(sl);
            this.fGG.f(sl, this.fGF.getItem(i));
        }
    }

    private void bpP() {
        this.fGE = !this.fGE;
        bU(this.fGB);
        if (this.fGF != null) {
            this.fGF.kA(this.fGE);
            this.fGF.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.fGE && this.fGI != null) {
            this.fGI.setBounds(0, (height - fGA) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.fGI.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.fGG = aVar;
    }
}
