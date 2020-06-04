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
    private TbPageContext<?> dIF;
    private b hjk;
    private ArrayList<i> hjm = new ArrayList<>();
    private p hjn;
    private int hjo;
    private int hjp;

    /* loaded from: classes10.dex */
    public interface b {
        void Et(String str);
    }

    public h(TbPageContext<?> tbPageContext) {
        this.hjo = 0;
        this.hjp = 0;
        this.dIF = tbPageContext;
        this.hjo = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.hjp = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hjm != null) {
            return this.hjm.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tu */
    public i getItem(int i) {
        if (this.hjm == null || i >= this.hjm.size()) {
            return null;
        }
        return this.hjm.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).bTq();
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
                view = LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                d dVar2 = new d();
                dVar2.mTextView = (TextView) view.findViewById(R.id.text_view_title);
                view.setTag(dVar2);
                dVar = dVar2;
            }
            dVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.dIF.getLayoutMode().onModeChanged(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof c)) {
                c cVar2 = (c) view.getTag();
                cVar2.hjr.setVisibility(0);
                cVar2.hjs.setVisibility(8);
                cVar2.hjt.setVisibility(8);
                cVar2.hju.setVisibility(8);
                cVar = cVar2;
            } else {
                view = LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                c cVar3 = new c();
                cVar3.mRoot = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                cVar3.hjr = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                cVar3.hjs = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                cVar3.hjt = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                cVar3.hju = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                view.setTag(cVar3);
                cVar = cVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar != null && bVar.bTr() != null && bVar.bTr().size() > 0) {
                if (bVar.isLast() && bVar.bTs()) {
                    cVar.mRoot.setPadding(this.hjo, 0, this.hjo, this.hjp);
                    if (this.hjn != null && !this.hjn.isEmpty()) {
                        if (bVar.bTr().size() == 2) {
                            if (bVar.bTt().equals(this.dIF.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                cVar.hju.setVisibility(8);
                                cVar.hjt.setVisibility(8);
                            } else if (bVar.bTt().equals(this.dIF.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                cVar.hju.setVisibility(8);
                                cVar.hjt.setVisibility(0);
                                cVar.hjt.aJ(this.dIF.getResources().getString(R.string.tip_assist_apply), this.hjn.bTC());
                                cVar.hjt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.hjk != null) {
                                            h.this.hjk.Et(h.this.hjn.bTD());
                                        }
                                    }
                                });
                            }
                        } else if (bVar.bTt().equals(this.dIF.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                            cVar.hjs.setVisibility(8);
                            cVar.hju.setVisibility(8);
                            cVar.hjt.setVisibility(8);
                        } else if (bVar.bTt().equals(this.dIF.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                            cVar.hjs.setVisibility(8);
                            cVar.hju.setVisibility(0);
                            cVar.hjt.setVisibility(8);
                            cVar.hju.aJ(this.dIF.getResources().getString(R.string.tip_assist_apply), this.hjn.bTC());
                            cVar.hju.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.hjk != null) {
                                        h.this.hjk.Et(h.this.hjn.bTD());
                                    }
                                }
                            });
                        }
                    }
                } else {
                    cVar.mRoot.setPadding(this.hjo, 0, this.hjo, 0);
                    cVar.hjt.setVisibility(8);
                    cVar.hju.setVisibility(8);
                }
                cVar.hjr.a(bVar.bTr().get(0));
                if (bVar.bTr().size() >= 2) {
                    cVar.hjs.a(bVar.bTr().get(1));
                    cVar.hjs.setVisibility(0);
                } else {
                    cVar.hjs.setVisibility(8);
                }
                this.dIF.getLayoutMode().onModeChanged(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.diS = view.findViewById(R.id.divider_view);
                view.setTag(aVar2);
            }
            this.dIF.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public void am(ArrayList<i> arrayList) {
        this.hjm = arrayList;
    }

    public void a(p pVar) {
        this.hjn = pVar;
    }

    public void a(b bVar) {
        this.hjk = bVar;
    }

    /* loaded from: classes10.dex */
    public class c {
        BawuMemberInfoView hjr;
        BawuMemberInfoView hjs;
        BawuManagerApplyInfoView hjt;
        BawuManagerApplyInfoView hju;
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
        View diS;

        public a() {
        }
    }
}
