package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.n0.r0.w1.a;
import d.a.n0.r0.w1.d.d;
/* loaded from: classes4.dex */
public class GameSubCommentView {

    /* renamed from: a  reason: collision with root package name */
    public View f15578a;

    /* renamed from: b  reason: collision with root package name */
    public SpannableTextView f15579b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC1612a f15580c;

    /* loaded from: classes4.dex */
    public static class GameSubCommentViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public GameSubCommentView f15581a;

        public GameSubCommentViewHolder(GameSubCommentView gameSubCommentView) {
            super(gameSubCommentView.c());
            this.f15581a = gameSubCommentView;
        }

        public void b(d dVar) {
            this.f15581a.b(dVar);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15582e;

        public a(d dVar) {
            this.f15582e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GameSubCommentView.this.f15580c != null) {
                GameSubCommentView.this.f15580c.c(this.f15582e);
            }
        }
    }

    public GameSubCommentView(TbPageContext<?> tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.f15578a = inflate;
        SpannableTextView spannableTextView = (SpannableTextView) inflate.findViewById(R.id.sub_comment_tv);
        this.f15579b = spannableTextView;
        SkinManager.setViewTextColor(spannableTextView, R.color.CAM_X0106);
    }

    public void b(d dVar) {
        if (dVar == null || dVar.f63467h == null) {
            return;
        }
        this.f15579b.e(dVar);
        this.f15579b.setOnClickListener(new a(dVar));
    }

    public View c() {
        return this.f15578a;
    }

    public void d(a.InterfaceC1612a interfaceC1612a) {
        this.f15580c = interfaceC1612a;
        this.f15579b.setClickListener(interfaceC1612a);
    }
}
