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
/* loaded from: classes16.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int iid = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View iie;
    private int iif;
    private int iig;
    private boolean iih;
    private com.baidu.tieba.frs.game.strategy.view.a iii;
    private a iij;
    private int iik;
    private Drawable iil;

    /* loaded from: classes16.dex */
    public interface a {
        void i(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iif = 0;
        this.iig = 0;
        this.iih = true;
        this.iik = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iif = 0;
        this.iig = 0;
        this.iih = true;
        this.iik = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.iif = 0;
        this.iig = 0;
        this.iih = true;
        this.iik = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.iie != null) {
            ci(this.iie);
        }
        if (this.iik != 0) {
            this.iil = ap.getDrawable(i, this.iik);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.iif = i;
        this.iig = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.iik = i;
        if (this.iik == 0) {
            this.iil = ap.getDrawable(i);
        } else {
            this.iil = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.iie == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.iie = frameLayout;
        }
        return this.iie;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void ci(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.iih) {
                    imageView.setImageDrawable(ap.getDrawable(this.iif));
                } else {
                    imageView.setImageDrawable(ap.getDrawable(this.iig));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean cqp() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (cqp()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.iii = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.iie) {
            if (this.iii != null && this.iii.cqr()) {
                cqq();
            }
        } else if (this.iij != null && this.iii != null) {
            int xZ = this.iii.xZ(i);
            this.iii.xY(xZ);
            this.iij.i(xZ, this.iii.getItem(i));
        }
    }

    private void cqq() {
        this.iih = !this.iih;
        ci(this.iie);
        if (this.iii != null) {
            this.iii.oR(this.iih);
            this.iii.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.iih && this.iil != null) {
            this.iil.setBounds(0, (height - iid) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.iil.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.iij = aVar;
    }
}
