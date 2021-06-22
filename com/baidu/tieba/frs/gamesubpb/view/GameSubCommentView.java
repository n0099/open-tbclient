package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.o0.r0.w1.a;
import d.a.o0.r0.w1.d.d;
/* loaded from: classes4.dex */
public class GameSubCommentView {

    /* renamed from: a  reason: collision with root package name */
    public View f15660a;

    /* renamed from: b  reason: collision with root package name */
    public SpannableTextView f15661b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC1616a f15662c;

    /* loaded from: classes4.dex */
    public static class GameSubCommentViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public GameSubCommentView f15663a;

        public GameSubCommentViewHolder(GameSubCommentView gameSubCommentView) {
            super(gameSubCommentView.c());
            this.f15663a = gameSubCommentView;
        }

        public void b(d dVar) {
            this.f15663a.b(dVar);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15664e;

        public a(d dVar) {
            this.f15664e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GameSubCommentView.this.f15662c != null) {
                GameSubCommentView.this.f15662c.c(this.f15664e);
            }
        }
    }

    public GameSubCommentView(TbPageContext<?> tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.f15660a = inflate;
        SpannableTextView spannableTextView = (SpannableTextView) inflate.findViewById(R.id.sub_comment_tv);
        this.f15661b = spannableTextView;
        SkinManager.setViewTextColor(spannableTextView, R.color.CAM_X0106);
    }

    public void b(d dVar) {
        if (dVar == null || dVar.f63592h == null) {
            return;
        }
        this.f15661b.e(dVar);
        this.f15661b.setOnClickListener(new a(dVar));
    }

    public View c() {
        return this.f15660a;
    }

    public void d(a.InterfaceC1616a interfaceC1616a) {
        this.f15662c = interfaceC1616a;
        this.f15661b.setClickListener(interfaceC1616a);
    }
}
