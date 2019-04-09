package com.baidu.tieba.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.b;
/* loaded from: classes.dex */
public abstract class a<T extends com.baidu.tieba.card.data.b> implements View.OnClickListener {
    public int currentPageType;
    protected ab<T> efg;
    public Context mContext;
    private String mFrom;
    public int mSkinType;
    private BdUniqueId mTag;
    public TbPageContext<?> mTbPageContext;
    private View mView;

    public abstract void a(T t);

    public abstract int getLayout();

    public abstract void onChangeSkinType(TbPageContext<?> tbPageContext, int i);

    public a(TbPageContext<?> tbPageContext) {
        this.mSkinType = 3;
        this.mTag = null;
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null, false);
    }

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        this.mSkinType = 3;
        this.mTag = null;
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mView = LayoutInflater.from(getContext()).inflate(getLayout(), viewGroup, false);
    }

    public BdUniqueId getTag() {
        return this.mTag;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public View getView() {
        return this.mView;
    }

    public Context getContext() {
        return this.mContext;
    }

    public TbPageContext<?> getTbPageContext() {
        return this.mTbPageContext;
    }

    public void onPause() {
    }

    public void onDestroy() {
    }

    public void setVisibility(int i) {
        if (this.mView != null) {
            this.mView.setVisibility(i);
        }
    }

    public void d(ab<T> abVar) {
        this.efg = abVar;
    }

    public ab<T> aQf() {
        return this.efg;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }
}
