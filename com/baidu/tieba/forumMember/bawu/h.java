package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private int bYW;
    private b ddP;
    private ArrayList<i> ddR = new ArrayList<>();
    private p ddS;
    private int ddT;
    private TbPageContext<?> mContext;

    /* loaded from: classes3.dex */
    public interface b {
        void mj(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.bYW = 0;
        this.ddT = 0;
        this.mContext = tbPageContext;
        this.bYW = l.e(tbPageContext.getPageActivity(), d.e.ds24);
        this.ddT = l.e(tbPageContext.getPageActivity(), d.e.ds30);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ddR != null) {
            return this.ddR.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jR */
    public i getItem(int i) {
        if (this.ddR == null || i >= this.ddR.size()) {
            return null;
        }
        return this.ddR.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).asc();
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
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(d.g.text_view_title);
                dVar2.mLine = view.findViewById(d.g.line_divider);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.mContext.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.ddW.setVisibility(0);
                cVar2.ddX.setVisibility(8);
                cVar2.ddY.setVisibility(8);
                cVar2.ddZ.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.ddV = (RelativeLayout) view.findViewById(d.g.bawu_item_member_root);
                cVar3.ddW = (BawuMemberInfoView) view.findViewById(d.g.left_member);
                cVar3.ddX = (BawuMemberInfoView) view.findViewById(d.g.right_member);
                cVar3.ddY = (BawuManagerApplyInfoView) view.findViewById(d.g.left_manager_apply);
                cVar3.ddZ = (BawuManagerApplyInfoView) view.findViewById(d.g.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.asd() != null && bVar.asd().size() > 0) {
                if (bVar.isLast()) {
                    cVar.ddV.setPadding(this.bYW, 0, this.bYW, this.ddT);
                    if (this.ddS != null && !this.ddS.isEmpty()) {
                        if (bVar.asd().size() == 2) {
                            if (bVar.ase().equals(this.mContext.getResources().getString(d.k.bawu_member_bazhu_tip))) {
                                cVar.ddZ.setVisibility(8);
                                cVar.ddY.setVisibility(0);
                                cVar.ddY.X(this.mContext.getResources().getString(d.k.tip_manager_apply), this.ddS.asp());
                                cVar.ddY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.ddP != null) {
                                            h.this.ddP.mj(h.this.ddS.ass());
                                        }
                                    }
                                });
                            } else if (bVar.ase().equals(this.mContext.getResources().getString(d.k.bawu_member_xbazhu_tip))) {
                                cVar.ddZ.setVisibility(8);
                                cVar.ddY.setVisibility(0);
                                cVar.ddY.X(this.mContext.getResources().getString(d.k.tip_assist_apply), this.ddS.asr());
                                cVar.ddY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.ddP != null) {
                                            h.this.ddP.mj(h.this.ddS.ast());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.ase().equals(this.mContext.getResources().getString(d.k.bawu_member_bazhu_tip))) {
                            cVar.ddX.setVisibility(8);
                            cVar.ddZ.setVisibility(0);
                            cVar.ddY.setVisibility(8);
                            cVar.ddZ.X(this.mContext.getResources().getString(d.k.tip_manager_apply), this.ddS.asp());
                            cVar.ddZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.ddP != null) {
                                        h.this.ddP.mj(h.this.ddS.ass());
                                    }
                                }
                            });
                        } else if (bVar.ase().equals(this.mContext.getResources().getString(d.k.bawu_member_xbazhu_tip))) {
                            cVar.ddX.setVisibility(8);
                            cVar.ddZ.setVisibility(0);
                            cVar.ddY.setVisibility(8);
                            cVar.ddZ.X(this.mContext.getResources().getString(d.k.tip_assist_apply), this.ddS.asr());
                            cVar.ddZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.ddP != null) {
                                        h.this.ddP.mj(h.this.ddS.ast());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.ddV.setPadding(this.bYW, 0, this.bYW, 0);
                    cVar.ddY.setVisibility(8);
                    cVar.ddZ.setVisibility(8);
                }
                cVar.ddW.a(bVar.asd().get(0));
                if (bVar.asd().size() >= 2) {
                    cVar.ddX.a(bVar.asd().get(1));
                    cVar.ddX.setVisibility(0);
                } else {
                    cVar.ddX.setVisibility(8);
                }
                this.mContext.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.cUb = view.findViewById(d.g.divider_view);
                view.setTag(aVar2);
            }
            this.mContext.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void H(ArrayList<i> arrayList) {
        this.ddR = arrayList;
    }

    public void a(p pVar) {
        this.ddS = pVar;
    }

    public void a(b bVar) {
        this.ddP = bVar;
    }

    /* loaded from: classes3.dex */
    public class c {
        RelativeLayout ddV;
        BawuMemberInfoView ddW;
        BawuMemberInfoView ddX;
        BawuManagerApplyInfoView ddY;
        BawuManagerApplyInfoView ddZ;

        public c() {
        }
    }

    /* loaded from: classes3.dex */
    public class d {
        View mLine;
        TextView mTextView;

        public d() {
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        View cUb;

        public a() {
        }
    }
}
