package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> cVv;
    private b gla;
    private ArrayList<i> glc = new ArrayList<>();
    private p gld;
    private int gle;
    private int glf;

    /* loaded from: classes10.dex */
    public interface b {
        void AW(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.gle = 0;
        this.glf = 0;
        this.cVv = tbPageContext;
        this.gle = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.glf = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.glc != null) {
            return this.glc.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sq */
    public i getItem(int i) {
        if (this.glc == null || i >= this.glc.size()) {
            return null;
        }
        return this.glc.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).bCu();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        d dVar;
        if (getItemViewType(i) == 0) {
            if (view != null && (view.getTag() instanceof d)) {
                dVar = (d) view.getTag();
            } else {
                view = LayoutInflater.from(this.cVv.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.cVv.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.glh.setVisibility(0);
                cVar2.gli.setVisibility(8);
                cVar2.glj.setVisibility(8);
                cVar2.glk.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.cVv.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.mRoot = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.glh = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.gli = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.glj = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.glk = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.bCv() != null && bVar.bCv().size() > 0) {
                if (bVar.isLast() && bVar.bCw()) {
                    cVar.mRoot.setPadding(this.gle, 0, this.gle, this.glf);
                    if (this.gld != null && !this.gld.isEmpty()) {
                        if (bVar.bCv().size() == 2) {
                            if (bVar.bCx().equals(this.cVv.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.glk.setVisibility(8);
                                cVar.glj.setVisibility(8);
                            } else if (bVar.bCx().equals(this.cVv.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.glk.setVisibility(8);
                                cVar.glj.setVisibility(0);
                                cVar.glj.ay(this.cVv.getResources().getString(R.string.tip_assist_apply), this.gld.bCG());
                                cVar.glj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.gla != null) {
                                            h.this.gla.AW(h.this.gld.bCH());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.bCx().equals(this.cVv.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.gli.setVisibility(8);
                            cVar.glk.setVisibility(8);
                            cVar.glj.setVisibility(8);
                        } else if (bVar.bCx().equals(this.cVv.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.gli.setVisibility(8);
                            cVar.glk.setVisibility(0);
                            cVar.glj.setVisibility(8);
                            cVar.glk.ay(this.cVv.getResources().getString(R.string.tip_assist_apply), this.gld.bCG());
                            cVar.glk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.gla != null) {
                                        h.this.gla.AW(h.this.gld.bCH());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.mRoot.setPadding(this.gle, 0, this.gle, 0);
                    cVar.glj.setVisibility(8);
                    cVar.glk.setVisibility(8);
                }
                cVar.glh.a(bVar.bCv().get(0));
                if (bVar.bCv().size() >= 2) {
                    cVar.gli.a(bVar.bCv().get(1));
                    cVar.gli.setVisibility(0);
                } else {
                    cVar.gli.setVisibility(8);
                }
                this.cVv.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.cVv.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.cyM = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.cVv.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void ak(ArrayList<i> arrayList) {
        this.glc = arrayList;
    }

    public void a(p pVar) {
        this.gld = pVar;
    }

    public void a(b bVar) {
        this.gla = bVar;
    }

    /* loaded from: classes10.dex */
    public class c {
        BawuMemberInfoView glh;
        BawuMemberInfoView gli;
        BawuManagerApplyInfoView glj;
        BawuManagerApplyInfoView glk;
        RelativeLayout mRoot;

        public c() {
        }
    }

    /* loaded from: classes10.dex */
    public class d {
        TextView mTextView;

        public d() {
        }
    }

    /* loaded from: classes10.dex */
    public class a {
        View cyM;

        public a() {
        }
    }
}
