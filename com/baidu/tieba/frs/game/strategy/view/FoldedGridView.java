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
    private static final int iDY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View iDZ;
    private int iEa;
    private int iEb;
    private boolean iEc;
    private com.baidu.tieba.frs.game.strategy.view.a iEd;
    private a iEe;
    private int iEf;
    private Drawable iEg;

    /* loaded from: classes22.dex */
    public interface a {
        void j(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iEa = 0;
        this.iEb = 0;
        this.iEc = true;
        this.iEf = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iEa = 0;
        this.iEb = 0;
        this.iEc = true;
        this.iEf = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.iEa = 0;
        this.iEb = 0;
        this.iEc = true;
        this.iEf = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.iDZ != null) {
            cv(this.iDZ);
        }
        if (this.iEf != 0) {
            this.iEg = ap.getDrawable(i, this.iEf);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.iEa = i;
        this.iEb = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.iEf = i;
        if (this.iEf == 0) {
            this.iEg = ap.getDrawable(i);
        } else {
            this.iEg = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.iDZ == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.iDZ = frameLayout;
        }
        return this.iDZ;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void cv(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.iEc) {
                    imageView.setImageDrawable(ap.getDrawable(this.iEa));
                } else {
                    imageView.setImageDrawable(ap.getDrawable(this.iEb));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean cwZ() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (cwZ()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.iEd = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.iDZ) {
            if (this.iEd != null && this.iEd.cxb()) {
                cxa();
            }
        } else if (this.iEe != null && this.iEd != null) {
            int ze = this.iEd.ze(i);
            this.iEd.zd(ze);
            this.iEe.j(ze, this.iEd.getItem(i));
        }
    }

    private void cxa() {
        this.iEc = !this.iEc;
        cv(this.iDZ);
        if (this.iEd != null) {
            this.iEd.pC(this.iEc);
            this.iEd.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.iEc && this.iEg != null) {
            this.iEg.setBounds(0, (height - iDY) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.iEg.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.iEe = aVar;
    }
}
