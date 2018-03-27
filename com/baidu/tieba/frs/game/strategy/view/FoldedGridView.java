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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, g {
    private static final int dOy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private int dOA;
    private int dOB;
    private boolean dOC;
    private com.baidu.tieba.frs.game.strategy.view.a dOD;
    private a dOE;
    private int dOF;
    private Drawable dOG;
    private View dOz;

    /* loaded from: classes3.dex */
    public interface a {
        void e(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dOA = 0;
        this.dOB = 0;
        this.dOC = true;
        this.dOF = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dOA = 0;
        this.dOB = 0;
        this.dOC = true;
        this.dOF = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.dOA = 0;
        this.dOB = 0;
        this.dOC = true;
        this.dOF = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.dOz != null) {
            bO(this.dOz);
        }
        if (this.dOF != 0) {
            this.dOG = aj.au(i, this.dOF);
        }
    }

    public void bD(int i, int i2) {
        this.dOA = i;
        this.dOB = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.dOF = i;
        if (this.dOF == 0) {
            this.dOG = aj.getDrawable(i);
        } else {
            this.dOG = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.g
    public View getArrowView() {
        if (this.dOz == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.dOz = frameLayout;
        }
        return this.dOz;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.g
    public void bO(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.dOC) {
                    imageView.setImageDrawable(aj.getDrawable(this.dOA));
                } else {
                    imageView.setImageDrawable(aj.getDrawable(this.dOB));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.g
    public boolean axY() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.g
    public int getArrowIndex() {
        if (axY()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.dOD = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.dOz) {
            if (this.dOD != null && this.dOD.aya()) {
                axZ();
            }
        } else if (this.dOE != null && this.dOD != null) {
            int nw = this.dOD.nw(i);
            this.dOD.nv(nw);
            this.dOE.e(nw, this.dOD.getItem(i));
        }
    }

    private void axZ() {
        this.dOC = !this.dOC;
        bO(this.dOz);
        if (this.dOD != null) {
            this.dOD.gh(this.dOC);
            this.dOD.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.dOC && this.dOG != null) {
            this.dOG.setBounds(0, (height - dOy) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.dOG.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.dOE = aVar;
    }
}
