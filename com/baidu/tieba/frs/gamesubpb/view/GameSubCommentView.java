package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.j0.q0.w1.a;
import d.b.j0.q0.w1.d.d;
/* loaded from: classes4.dex */
public class GameSubCommentView {

    /* renamed from: a  reason: collision with root package name */
    public View f16094a;

    /* renamed from: b  reason: collision with root package name */
    public SpannableTextView f16095b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC1530a f16096c;

    /* loaded from: classes4.dex */
    public static class GameSubCommentViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public GameSubCommentView f16097a;

        public GameSubCommentViewHolder(GameSubCommentView gameSubCommentView) {
            super(gameSubCommentView.c());
            this.f16097a = gameSubCommentView;
        }

        public void b(d dVar) {
            this.f16097a.b(dVar);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f16098e;

        public a(d dVar) {
            this.f16098e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GameSubCommentView.this.f16096c != null) {
                GameSubCommentView.this.f16096c.a(this.f16098e);
            }
        }
    }

    public GameSubCommentView(TbPageContext<?> tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.f16094a = inflate;
        SpannableTextView spannableTextView = (SpannableTextView) inflate.findViewById(R.id.sub_comment_tv);
        this.f16095b = spannableTextView;
        SkinManager.setViewTextColor(spannableTextView, R.color.CAM_X0106);
    }

    public void b(d dVar) {
        if (dVar == null || dVar.f60781h == null) {
            return;
        }
        this.f16095b.e(dVar);
        this.f16095b.setOnClickListener(new a(dVar));
    }

    public View c() {
        return this.f16094a;
    }

    public void d(a.InterfaceC1530a interfaceC1530a) {
        this.f16096c = interfaceC1530a;
        this.f16095b.setClickListener(interfaceC1530a);
    }
}
