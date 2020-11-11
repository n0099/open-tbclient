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
/* loaded from: classes23.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> eIc;
    private b iCT;
    private ArrayList<i> iCV = new ArrayList<>();
    private p iCW;
    private int iCX;
    private int iCY;

    /* loaded from: classes23.dex */
    public interface b {
        void Kh(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.iCX = 0;
        this.iCY = 0;
        this.eIc = tbPageContext;
        this.iCX = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.iCY = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iCV != null) {
            return this.iCV.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: yn */
    public i getItem(int i) {
        if (this.iCV == null || i >= this.iCV.size()) {
            return null;
        }
        return this.iCV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).cww();
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
                view = LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.eIc.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.iDa.setVisibility(0);
                cVar2.iDb.setVisibility(8);
                cVar2.iDc.setVisibility(8);
                cVar2.iDd.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.mRoot = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.iDa = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.iDb = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.iDc = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.iDd = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.cwx() != null && bVar.cwx().size() > 0) {
                if (bVar.isLast() && bVar.cwy()) {
                    cVar.mRoot.setPadding(this.iCX, 0, this.iCX, this.iCY);
                    if (this.iCW != null && !this.iCW.isEmpty()) {
                        if (bVar.cwx().size() == 2) {
                            if (bVar.cwz().equals(this.eIc.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.iDd.setVisibility(8);
                                cVar.iDc.setVisibility(8);
                            } else if (bVar.cwz().equals(this.eIc.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.iDd.setVisibility(8);
                                cVar.iDc.setVisibility(0);
                                cVar.iDc.aO(this.eIc.getResources().getString(R.string.tip_assist_apply), this.iCW.cwI());
                                cVar.iDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.iCT != null) {
                                            h.this.iCT.Kh(h.this.iCW.cwJ());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.cwz().equals(this.eIc.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.iDb.setVisibility(8);
                            cVar.iDd.setVisibility(8);
                            cVar.iDc.setVisibility(8);
                        } else if (bVar.cwz().equals(this.eIc.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.iDb.setVisibility(8);
                            cVar.iDd.setVisibility(0);
                            cVar.iDc.setVisibility(8);
                            cVar.iDd.aO(this.eIc.getResources().getString(R.string.tip_assist_apply), this.iCW.cwI());
                            cVar.iDd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.iCT != null) {
                                        h.this.iCT.Kh(h.this.iCW.cwJ());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.mRoot.setPadding(this.iCX, 0, this.iCX, 0);
                    cVar.iDc.setVisibility(8);
                    cVar.iDd.setVisibility(8);
                }
                cVar.iDa.a(bVar.cwx().get(0));
                if (bVar.cwx().size() >= 2) {
                    cVar.iDb.a(bVar.cwx().get(1));
                    cVar.iDb.setVisibility(0);
                } else {
                    cVar.iDb.setVisibility(8);
                }
                this.eIc.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.efQ = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.eIc.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void aw(ArrayList<i> arrayList) {
        this.iCV = arrayList;
    }

    public void a(p pVar) {
        this.iCW = pVar;
    }

    public void a(b bVar) {
        this.iCT = bVar;
    }

    /* loaded from: classes23.dex */
    public class c {
        BawuMemberInfoView iDa;
        BawuMemberInfoView iDb;
        BawuManagerApplyInfoView iDc;
        BawuManagerApplyInfoView iDd;
        RelativeLayout mRoot;

        public c() {
        }
    }

    /* loaded from: classes23.dex */
    public class d {
        TextView mTextView;

        public d() {
        }
    }

    /* loaded from: classes23.dex */
    public class a {
        View efQ;

        public a() {
        }
    }
}
