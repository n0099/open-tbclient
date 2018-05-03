package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> adf;
    private int bQf;
    private p cTA;
    private int cTB;
    private ArrayList<i> cTz = new ArrayList<>();

    public h(TbPageContext<?> tbPageContext) {
        this.bQf = 0;
        this.cTB = 0;
        this.adf = tbPageContext;
        this.bQf = l.e(tbPageContext.getPageActivity(), d.e.ds24);
        this.cTB = l.e(tbPageContext.getPageActivity(), d.e.ds30);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cTz != null) {
            return this.cTz.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jP */
    public i getItem(int i) {
        if (this.cTz == null || i >= this.cTz.size()) {
            return null;
        }
        return this.cTz.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).anY();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        b bVar;
        c cVar;
        if (getItemViewType(i) == 0) {
            if (view2 != null && (view2.getTag() instanceof c)) {
                cVar = (c) view2.getTag();
            } else {
                view2 = LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.bawu_item_title_view, viewGroup, false);
                c cVar2 = new c();
                cVar2.mTextView = (TextView) view2.findViewById(d.g.text_view_title);
                cVar2.mLine = view2.findViewById(d.g.line_divider);
                view2.setTag(cVar2);
                cVar = cVar2;
            }
            cVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.adf.getLayoutMode().u(view2);
        } else if (getItemViewType(i) == 1) {
            if (view2 != null && (view2.getTag() instanceof b)) {
                b bVar2 = (b) view2.getTag();
                bVar2.cTE.setVisibility(0);
                bVar2.cTF.setVisibility(8);
                bVar2.cTG.setVisibility(8);
                bVar2.cTH.setVisibility(8);
                bVar = bVar2;
            } else {
                view2 = LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.bawu_item_member, viewGroup, false);
                b bVar3 = new b();
                bVar3.cTD = (RelativeLayout) view2.findViewById(d.g.bawu_item_member_root);
                bVar3.cTE = (BawuMemberInfoView) view2.findViewById(d.g.left_member);
                bVar3.cTF = (BawuMemberInfoView) view2.findViewById(d.g.right_member);
                bVar3.cTG = (BawuManagerApplyInfoView) view2.findViewById(d.g.left_manager_apply);
                bVar3.cTH = (BawuManagerApplyInfoView) view2.findViewById(d.g.right_manager_apply);
                view2.setTag(bVar3);
                bVar = bVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar4 = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar4 != null && bVar4.anZ() != null && bVar4.anZ().size() > 0) {
                if (bVar4.isLast()) {
                    bVar.cTD.setPadding(this.bQf, 0, this.bQf, this.cTB);
                    if (this.cTA != null && !this.cTA.isEmpty()) {
                        if (bVar4.anZ().size() == 2) {
                            if (bVar4.aoa().equals(this.adf.getResources().getString(d.k.bawu_member_bazhu_tip))) {
                                bVar.cTH.setVisibility(8);
                                bVar.cTG.setVisibility(0);
                                bVar.cTG.V(this.adf.getResources().getString(d.k.tip_manager_apply), this.cTA.aol());
                                bVar.cTG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view3) {
                                        ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(h.this.adf.getPageActivity()), new String[]{h.this.cTA.aoo()});
                                    }
                                });
                            } else if (bVar4.aoa().equals(this.adf.getResources().getString(d.k.bawu_member_xbazhu_tip))) {
                                bVar.cTH.setVisibility(8);
                                bVar.cTG.setVisibility(0);
                                bVar.cTG.V(this.adf.getResources().getString(d.k.tip_assist_apply), this.cTA.aon());
                                bVar.cTG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view3) {
                                        ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(h.this.adf.getPageActivity()), new String[]{h.this.cTA.aop()});
                                    }
                                });
                            }
                        } else if (bVar4.aoa().equals(this.adf.getResources().getString(d.k.bawu_member_bazhu_tip))) {
                            bVar.cTF.setVisibility(8);
                            bVar.cTH.setVisibility(0);
                            bVar.cTG.setVisibility(8);
                            bVar.cTH.V(this.adf.getResources().getString(d.k.tip_manager_apply), this.cTA.aol());
                            bVar.cTH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view3) {
                                    ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(h.this.adf.getPageActivity()), new String[]{h.this.cTA.aoo()});
                                }
                            });
                        } else if (bVar4.aoa().equals(this.adf.getResources().getString(d.k.bawu_member_xbazhu_tip))) {
                            bVar.cTF.setVisibility(8);
                            bVar.cTH.setVisibility(0);
                            bVar.cTG.setVisibility(8);
                            bVar.cTH.V(this.adf.getResources().getString(d.k.tip_assist_apply), this.cTA.aon());
                            bVar.cTH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view3) {
                                    ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(h.this.adf.getPageActivity()), new String[]{h.this.cTA.aop()});
                                }
                            });
                        }
                    }
                } else {
                    bVar.cTD.setPadding(this.bQf, 0, this.bQf, 0);
                    bVar.cTG.setVisibility(8);
                    bVar.cTH.setVisibility(8);
                }
                bVar.cTE.a(bVar4.anZ().get(0));
                if (bVar4.anZ().size() >= 2) {
                    bVar.cTF.a(bVar4.anZ().get(1));
                    bVar.cTF.setVisibility(0);
                } else {
                    bVar.cTF.setVisibility(8);
                }
                this.adf.getLayoutMode().u(view2);
            }
        } else if (getItemViewType(i) == 2) {
            if (view2 != null && (view2.getTag() instanceof a)) {
                a aVar = (a) view2.getTag();
            } else {
                view2 = LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.cJM = view2.findViewById(d.g.divider_view);
                view2.setTag(aVar2);
            }
            this.adf.getLayoutMode().u(view2);
        }
        return view2;
    }

    public void I(ArrayList<i> arrayList) {
        this.cTz = arrayList;
    }

    public void a(p pVar) {
        this.cTA = pVar;
    }

    /* loaded from: classes3.dex */
    public class b {
        RelativeLayout cTD;
        BawuMemberInfoView cTE;
        BawuMemberInfoView cTF;
        BawuManagerApplyInfoView cTG;
        BawuManagerApplyInfoView cTH;

        public b() {
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        View mLine;
        TextView mTextView;

        public c() {
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        View cJM;

        public a() {
        }
    }
}
