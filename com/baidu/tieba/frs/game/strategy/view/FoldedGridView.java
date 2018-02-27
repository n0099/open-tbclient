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
    private static final int dOt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private int dOA;
    private Drawable dOB;
    private View dOu;
    private int dOv;
    private int dOw;
    private boolean dOx;
    private com.baidu.tieba.frs.game.strategy.view.a dOy;
    private a dOz;

    /* loaded from: classes3.dex */
    public interface a {
        void e(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dOv = 0;
        this.dOw = 0;
        this.dOx = true;
        this.dOA = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dOv = 0;
        this.dOw = 0;
        this.dOx = true;
        this.dOA = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.dOv = 0;
        this.dOw = 0;
        this.dOx = true;
        this.dOA = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.dOu != null) {
            bO(this.dOu);
        }
        if (this.dOA != 0) {
            this.dOB = aj.au(i, this.dOA);
        }
    }

    public void bD(int i, int i2) {
        this.dOv = i;
        this.dOw = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.dOA = i;
        if (this.dOA == 0) {
            this.dOB = aj.getDrawable(i);
        } else {
            this.dOB = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.g
    public View getArrowView() {
        if (this.dOu == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.dOu = frameLayout;
        }
        return this.dOu;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.g
    public void bO(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.dOx) {
                    imageView.setImageDrawable(aj.getDrawable(this.dOv));
                } else {
                    imageView.setImageDrawable(aj.getDrawable(this.dOw));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.g
    public boolean axW() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.g
    public int getArrowIndex() {
        if (axW()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.dOy = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.dOu) {
            if (this.dOy != null && this.dOy.axY()) {
                axX();
            }
        } else if (this.dOz != null && this.dOy != null) {
            int nw = this.dOy.nw(i);
            this.dOy.nv(nw);
            this.dOz.e(nw, this.dOy.getItem(i));
        }
    }

    private void axX() {
        this.dOx = !this.dOx;
        bO(this.dOu);
        if (this.dOy != null) {
            this.dOy.gg(this.dOx);
            this.dOy.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.dOx && this.dOB != null) {
            this.dOB.setBounds(0, (height - dOt) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.dOB.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.dOz = aVar;
    }
}
