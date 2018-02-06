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
    private static final int dOF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private View dOG;
    private int dOH;
    private int dOI;
    private boolean dOJ;
    private com.baidu.tieba.frs.game.strategy.view.a dOK;
    private a dOL;
    private int dOM;
    private Drawable dON;

    /* loaded from: classes3.dex */
    public interface a {
        void e(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dOH = 0;
        this.dOI = 0;
        this.dOJ = true;
        this.dOM = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dOH = 0;
        this.dOI = 0;
        this.dOJ = true;
        this.dOM = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.dOH = 0;
        this.dOI = 0;
        this.dOJ = true;
        this.dOM = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.dOG != null) {
            bO(this.dOG);
        }
        if (this.dOM != 0) {
            this.dON = aj.au(i, this.dOM);
        }
    }

    public void bD(int i, int i2) {
        this.dOH = i;
        this.dOI = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.dOM = i;
        if (this.dOM == 0) {
            this.dON = aj.getDrawable(i);
        } else {
            this.dON = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.g
    public View getArrowView() {
        if (this.dOG == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.dOG = frameLayout;
        }
        return this.dOG;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.g
    public void bO(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.dOJ) {
                    imageView.setImageDrawable(aj.getDrawable(this.dOH));
                } else {
                    imageView.setImageDrawable(aj.getDrawable(this.dOI));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.g
    public boolean axX() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.g
    public int getArrowIndex() {
        if (axX()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.dOK = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.dOG) {
            if (this.dOK != null && this.dOK.axZ()) {
                axY();
            }
        } else if (this.dOL != null && this.dOK != null) {
            int nw = this.dOK.nw(i);
            this.dOK.nv(nw);
            this.dOL.e(nw, this.dOK.getItem(i));
        }
    }

    private void axY() {
        this.dOJ = !this.dOJ;
        bO(this.dOG);
        if (this.dOK != null) {
            this.dOK.gg(this.dOJ);
            this.dOK.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.dOJ && this.dON != null) {
            this.dON.setBounds(0, (height - dOF) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.dON.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.dOL = aVar;
    }
}
