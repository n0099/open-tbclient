package com.baidu.tieba.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.b;
/* loaded from: classes.dex */
public abstract class a<T extends com.baidu.tieba.card.a.b> implements View.OnClickListener {
    private aq<T> aNl;
    private Context mContext;
    private String mFrom;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private BdUniqueId mTag = null;
    private View mView = LayoutInflater.from(getContext()).inflate(Ig(), (ViewGroup) null, false);

    public abstract int Ig();

    public a(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
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

    public TbPageContext<?> Ie() {
        return this.mTbPageContext;
    }

    public void a(aq<T> aqVar) {
        this.aNl = aqVar;
    }

    public aq<T> If() {
        return this.aNl;
    }
}
