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
    private static final int ihX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View ihY;
    private int ihZ;
    private int iia;
    private boolean iib;
    private com.baidu.tieba.frs.game.strategy.view.a iic;
    private a iid;
    private int iie;
    private Drawable iif;

    /* loaded from: classes16.dex */
    public interface a {
        void i(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ihZ = 0;
        this.iia = 0;
        this.iib = true;
        this.iie = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ihZ = 0;
        this.iia = 0;
        this.iib = true;
        this.iie = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.ihZ = 0;
        this.iia = 0;
        this.iib = true;
        this.iie = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.ihY != null) {
            ci(this.ihY);
        }
        if (this.iie != 0) {
            this.iif = ap.getDrawable(i, this.iie);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.ihZ = i;
        this.iia = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.iie = i;
        if (this.iie == 0) {
            this.iif = ap.getDrawable(i);
        } else {
            this.iif = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.ihY == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.ihY = frameLayout;
        }
        return this.ihY;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void ci(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.iib) {
                    imageView.setImageDrawable(ap.getDrawable(this.ihZ));
                } else {
                    imageView.setImageDrawable(ap.getDrawable(this.iia));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean cqo() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (cqo()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.iic = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.ihY) {
            if (this.iic != null && this.iic.cqq()) {
                cqp();
            }
        } else if (this.iid != null && this.iic != null) {
            int xZ = this.iic.xZ(i);
            this.iic.xY(xZ);
            this.iid.i(xZ, this.iic.getItem(i));
        }
    }

    private void cqp() {
        this.iib = !this.iib;
        ci(this.ihY);
        if (this.iic != null) {
            this.iic.oP(this.iib);
            this.iic.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.iib && this.iif != null) {
            this.iif.setBounds(0, (height - ihX) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.iif.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.iid = aVar;
    }
}
