package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import d.b.i0.r.q.a2;
import d.b.j0.x.m;
/* loaded from: classes4.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public ClickableHeaderImageView f16720e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16721f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16722g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16723h;
    public View i;
    public a2 j;
    public View.OnClickListener k;
    public View.OnClickListener l;
    public View.OnClickListener m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ConcernForumThreadUserInfoLayout.this.j == null || StringUtils.isNull(ConcernForumThreadUserInfoLayout.this.j.i0())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ConcernForumThreadUserInfoLayout.this.getContext()).createNormalCfg(ConcernForumThreadUserInfoLayout.this.j.i0(), m.g())));
            if (ConcernForumThreadUserInfoLayout.this.l != null) {
                ConcernForumThreadUserInfoLayout.this.l.onClick(view);
            }
        }
    }

    public ConcernForumThreadUserInfoLayout(Context context) {
        this(context, null);
    }

    public final void c(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
        this.f16720e = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.f16721f = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
        this.f16722g = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
        this.f16723h = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.i = inflate.findViewById(R.id.divider);
        setGravity(16);
        d();
        this.f16721f.setOnClickListener(this.m);
    }

    public final void d() {
        ClickableHeaderImageView clickableHeaderImageView = this.f16720e;
        if (clickableHeaderImageView == null) {
            return;
        }
        clickableHeaderImageView.setDefaultResource(17170445);
        this.f16720e.setDefaultBgResource(R.color.CAM_X0205);
        this.f16720e.setIsRound(true);
        this.f16720e.setOnClickListener(this.m);
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.f16720e;
    }

    public boolean getIsSimpleThread() {
        return false;
    }

    public TextView getUserName() {
        return this.f16722g;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        ClickableHeaderImageView clickableHeaderImageView = this.f16720e;
        if (clickableHeaderImageView != null) {
            clickableHeaderImageView.setPageId(bdUniqueId);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.k = onClickListener;
        ClickableHeaderImageView clickableHeaderImageView = this.f16720e;
        if (clickableHeaderImageView != null) {
            clickableHeaderImageView.setAfterClickListener(onClickListener);
        }
    }

    public ConcernForumThreadUserInfoLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ConcernForumThreadUserInfoLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = new a();
        c(getContext());
    }
}
