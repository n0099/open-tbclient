package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.i0.q0.w1.a;
import d.b.i0.q0.w1.d.d;
/* loaded from: classes4.dex */
public class GameSubCommentView {

    /* renamed from: a  reason: collision with root package name */
    public View f16086a;

    /* renamed from: b  reason: collision with root package name */
    public SpannableTextView f16087b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC1507a f16088c;

    /* loaded from: classes4.dex */
    public static class GameSubCommentViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public GameSubCommentView f16089a;

        public GameSubCommentViewHolder(GameSubCommentView gameSubCommentView) {
            super(gameSubCommentView.c());
            this.f16089a = gameSubCommentView;
        }

        public void b(d dVar) {
            this.f16089a.b(dVar);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f16090e;

        public a(d dVar) {
            this.f16090e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GameSubCommentView.this.f16088c != null) {
                GameSubCommentView.this.f16088c.a(this.f16090e);
            }
        }
    }

    public GameSubCommentView(TbPageContext<?> tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.f16086a = inflate;
        SpannableTextView spannableTextView = (SpannableTextView) inflate.findViewById(R.id.sub_comment_tv);
        this.f16087b = spannableTextView;
        SkinManager.setViewTextColor(spannableTextView, R.color.CAM_X0106);
    }

    public void b(d dVar) {
        if (dVar == null || dVar.f60360h == null) {
            return;
        }
        this.f16087b.e(dVar);
        this.f16087b.setOnClickListener(new a(dVar));
    }

    public View c() {
        return this.f16086a;
    }

    public void d(a.InterfaceC1507a interfaceC1507a) {
        this.f16088c = interfaceC1507a;
        this.f16087b.setClickListener(interfaceC1507a);
    }
}
