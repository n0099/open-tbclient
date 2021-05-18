package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.k0.q0.w1.a;
import d.a.k0.q0.w1.d.d;
/* loaded from: classes4.dex */
public class GameSubCommentView {

    /* renamed from: a  reason: collision with root package name */
    public View f15613a;

    /* renamed from: b  reason: collision with root package name */
    public SpannableTextView f15614b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC1543a f15615c;

    /* loaded from: classes4.dex */
    public static class GameSubCommentViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public GameSubCommentView f15616a;

        public GameSubCommentViewHolder(GameSubCommentView gameSubCommentView) {
            super(gameSubCommentView.c());
            this.f15616a = gameSubCommentView;
        }

        public void b(d dVar) {
            this.f15616a.b(dVar);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15617e;

        public a(d dVar) {
            this.f15617e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GameSubCommentView.this.f15615c != null) {
                GameSubCommentView.this.f15615c.c(this.f15617e);
            }
        }
    }

    public GameSubCommentView(TbPageContext<?> tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.f15613a = inflate;
        SpannableTextView spannableTextView = (SpannableTextView) inflate.findViewById(R.id.sub_comment_tv);
        this.f15614b = spannableTextView;
        SkinManager.setViewTextColor(spannableTextView, R.color.CAM_X0106);
    }

    public void b(d dVar) {
        if (dVar == null || dVar.f59635h == null) {
            return;
        }
        this.f15614b.e(dVar);
        this.f15614b.setOnClickListener(new a(dVar));
    }

    public View c() {
        return this.f15613a;
    }

    public void d(a.InterfaceC1543a interfaceC1543a) {
        this.f15615c = interfaceC1543a;
        this.f15614b.setClickListener(interfaceC1543a);
    }
}
