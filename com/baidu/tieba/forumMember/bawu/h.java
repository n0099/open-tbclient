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
/* loaded from: classes8.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> cRe;
    private b gib;
    private ArrayList<i> gie = new ArrayList<>();
    private p gif;
    private int gig;
    private int gih;

    /* loaded from: classes8.dex */
    public interface b {
        void AE(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.gig = 0;
        this.gih = 0;
        this.cRe = tbPageContext;
        this.gig = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.gih = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gie != null) {
            return this.gie.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: si */
    public i getItem(int i) {
        if (this.gie == null || i >= this.gie.size()) {
            return null;
        }
        return this.gie.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).bAJ();
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
                view = LayoutInflater.from(this.cRe.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.cRe.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.gij.setVisibility(0);
                cVar2.gik.setVisibility(8);
                cVar2.gil.setVisibility(8);
                cVar2.gim.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.cRe.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.mRoot = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.gij = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.gik = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.gil = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.gim = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.bAK() != null && bVar.bAK().size() > 0) {
                if (bVar.isLast() && bVar.bAL()) {
                    cVar.mRoot.setPadding(this.gig, 0, this.gig, this.gih);
                    if (this.gif != null && !this.gif.isEmpty()) {
                        if (bVar.bAK().size() == 2) {
                            if (bVar.bAM().equals(this.cRe.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.gim.setVisibility(8);
                                cVar.gil.setVisibility(8);
                            } else if (bVar.bAM().equals(this.cRe.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.gim.setVisibility(8);
                                cVar.gil.setVisibility(0);
                                cVar.gil.aA(this.cRe.getResources().getString(R.string.tip_assist_apply), this.gif.bAV());
                                cVar.gil.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.gib != null) {
                                            h.this.gib.AE(h.this.gif.bAW());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.bAM().equals(this.cRe.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.gik.setVisibility(8);
                            cVar.gim.setVisibility(8);
                            cVar.gil.setVisibility(8);
                        } else if (bVar.bAM().equals(this.cRe.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.gik.setVisibility(8);
                            cVar.gim.setVisibility(0);
                            cVar.gil.setVisibility(8);
                            cVar.gim.aA(this.cRe.getResources().getString(R.string.tip_assist_apply), this.gif.bAV());
                            cVar.gim.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.gib != null) {
                                        h.this.gib.AE(h.this.gif.bAW());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.mRoot.setPadding(this.gig, 0, this.gig, 0);
                    cVar.gil.setVisibility(8);
                    cVar.gim.setVisibility(8);
                }
                cVar.gij.a(bVar.bAK().get(0));
                if (bVar.bAK().size() >= 2) {
                    cVar.gik.a(bVar.bAK().get(1));
                    cVar.gik.setVisibility(0);
                } else {
                    cVar.gik.setVisibility(8);
                }
                this.cRe.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.cRe.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.cuB = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.cRe.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void ak(ArrayList<i> arrayList) {
        this.gie = arrayList;
    }

    public void a(p pVar) {
        this.gif = pVar;
    }

    public void a(b bVar) {
        this.gib = bVar;
    }

    /* loaded from: classes8.dex */
    public class c {
        BawuMemberInfoView gij;
        BawuMemberInfoView gik;
        BawuManagerApplyInfoView gil;
        BawuManagerApplyInfoView gim;
        RelativeLayout mRoot;

        public c() {
        }
    }

    /* loaded from: classes8.dex */
    public class d {
        TextView mTextView;

        public d() {
        }
    }

    /* loaded from: classes8.dex */
    public class a {
        View cuB;

        public a() {
        }
    }
}
