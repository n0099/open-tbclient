package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.i0.p0.w1.a;
import d.b.i0.p0.w1.d.d;
/* loaded from: classes4.dex */
public class GameSubCommentView {

    /* renamed from: a  reason: collision with root package name */
    public View f16425a;

    /* renamed from: b  reason: collision with root package name */
    public SpannableTextView f16426b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC1444a f16427c;

    /* loaded from: classes4.dex */
    public static class GameSubCommentViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public GameSubCommentView f16428a;

        public GameSubCommentViewHolder(GameSubCommentView gameSubCommentView) {
            super(gameSubCommentView.c());
            this.f16428a = gameSubCommentView;
        }

        public void b(d dVar) {
            this.f16428a.b(dVar);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f16429e;

        public a(d dVar) {
            this.f16429e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GameSubCommentView.this.f16427c != null) {
                GameSubCommentView.this.f16427c.a(this.f16429e);
            }
        }
    }

    public GameSubCommentView(TbPageContext<?> tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.f16425a = inflate;
        SpannableTextView spannableTextView = (SpannableTextView) inflate.findViewById(R.id.sub_comment_tv);
        this.f16426b = spannableTextView;
        SkinManager.setViewTextColor(spannableTextView, R.color.CAM_X0106);
    }

    public void b(d dVar) {
        if (dVar == null || dVar.f58692h == null) {
            return;
        }
        this.f16426b.e(dVar);
        this.f16426b.setOnClickListener(new a(dVar));
    }

    public View c() {
        return this.f16425a;
    }

    public void d(a.InterfaceC1444a interfaceC1444a) {
        this.f16427c = interfaceC1444a;
        this.f16426b.setClickListener(interfaceC1444a);
    }
}
