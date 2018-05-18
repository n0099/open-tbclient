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
    private int bQV;
    private ArrayList<i> cUG = new ArrayList<>();
    private p cUH;
    private int cUI;
    private TbPageContext<?> mContext;

    public h(TbPageContext<?> tbPageContext) {
        this.bQV = 0;
        this.cUI = 0;
        this.mContext = tbPageContext;
        this.bQV = l.e(tbPageContext.getPageActivity(), d.e.ds24);
        this.cUI = l.e(tbPageContext.getPageActivity(), d.e.ds30);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cUG != null) {
            return this.cUG.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jO */
    public i getItem(int i) {
        if (this.cUG == null || i >= this.cUG.size()) {
            return null;
        }
        return this.cUG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).anX();
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
                view2 = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.bawu_item_title_view, viewGroup, false);
                c cVar2 = new c();
                cVar2.mTextView = (TextView) view2.findViewById(d.g.text_view_title);
                cVar2.mLine = view2.findViewById(d.g.line_divider);
                view2.setTag(cVar2);
                cVar = cVar2;
            }
            cVar.mTextView.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.mContext.getLayoutMode().u(view2);
        } else if (getItemViewType(i) == 1) {
            if (view2 != null && (view2.getTag() instanceof b)) {
                b bVar2 = (b) view2.getTag();
                bVar2.cUL.setVisibility(0);
                bVar2.cUM.setVisibility(8);
                bVar2.cUN.setVisibility(8);
                bVar2.cUO.setVisibility(8);
                bVar = bVar2;
            } else {
                view2 = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.bawu_item_member, viewGroup, false);
                b bVar3 = new b();
                bVar3.cUK = (RelativeLayout) view2.findViewById(d.g.bawu_item_member_root);
                bVar3.cUL = (BawuMemberInfoView) view2.findViewById(d.g.left_member);
                bVar3.cUM = (BawuMemberInfoView) view2.findViewById(d.g.right_member);
                bVar3.cUN = (BawuManagerApplyInfoView) view2.findViewById(d.g.left_manager_apply);
                bVar3.cUO = (BawuManagerApplyInfoView) view2.findViewById(d.g.right_manager_apply);
                view2.setTag(bVar3);
                bVar = bVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar4 = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar4 != null && bVar4.anY() != null && bVar4.anY().size() > 0) {
                if (bVar4.isLast()) {
                    bVar.cUK.setPadding(this.bQV, 0, this.bQV, this.cUI);
                    if (this.cUH != null && !this.cUH.isEmpty()) {
                        if (bVar4.anY().size() == 2) {
                            if (bVar4.anZ().equals(this.mContext.getResources().getString(d.k.bawu_member_bazhu_tip))) {
                                bVar.cUO.setVisibility(8);
                                bVar.cUN.setVisibility(0);
                                bVar.cUN.V(this.mContext.getResources().getString(d.k.tip_manager_apply), this.cUH.aok());
                                bVar.cUN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view3) {
                                        ax.wf().c((TbPageContext) com.baidu.adp.base.i.ab(h.this.mContext.getPageActivity()), new String[]{h.this.cUH.aon()});
                                    }
                                });
                            } else if (bVar4.anZ().equals(this.mContext.getResources().getString(d.k.bawu_member_xbazhu_tip))) {
                                bVar.cUO.setVisibility(8);
                                bVar.cUN.setVisibility(0);
                                bVar.cUN.V(this.mContext.getResources().getString(d.k.tip_assist_apply), this.cUH.aom());
                                bVar.cUN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view3) {
                                        ax.wf().c((TbPageContext) com.baidu.adp.base.i.ab(h.this.mContext.getPageActivity()), new String[]{h.this.cUH.aoo()});
                                    }
                                });
                            }
                        } else if (bVar4.anZ().equals(this.mContext.getResources().getString(d.k.bawu_member_bazhu_tip))) {
                            bVar.cUM.setVisibility(8);
                            bVar.cUO.setVisibility(0);
                            bVar.cUN.setVisibility(8);
                            bVar.cUO.V(this.mContext.getResources().getString(d.k.tip_manager_apply), this.cUH.aok());
                            bVar.cUO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view3) {
                                    ax.wf().c((TbPageContext) com.baidu.adp.base.i.ab(h.this.mContext.getPageActivity()), new String[]{h.this.cUH.aon()});
                                }
                            });
                        } else if (bVar4.anZ().equals(this.mContext.getResources().getString(d.k.bawu_member_xbazhu_tip))) {
                            bVar.cUM.setVisibility(8);
                            bVar.cUO.setVisibility(0);
                            bVar.cUN.setVisibility(8);
                            bVar.cUO.V(this.mContext.getResources().getString(d.k.tip_assist_apply), this.cUH.aom());
                            bVar.cUO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view3) {
                                    ax.wf().c((TbPageContext) com.baidu.adp.base.i.ab(h.this.mContext.getPageActivity()), new String[]{h.this.cUH.aoo()});
                                }
                            });
                        }
                    }
                } else {
                    bVar.cUK.setPadding(this.bQV, 0, this.bQV, 0);
                    bVar.cUN.setVisibility(8);
                    bVar.cUO.setVisibility(8);
                }
                bVar.cUL.a(bVar4.anY().get(0));
                if (bVar4.anY().size() >= 2) {
                    bVar.cUM.a(bVar4.anY().get(1));
                    bVar.cUM.setVisibility(0);
                } else {
                    bVar.cUM.setVisibility(8);
                }
                this.mContext.getLayoutMode().u(view2);
            }
        } else if (getItemViewType(i) == 2) {
            if (view2 != null && (view2.getTag() instanceof a)) {
                a aVar = (a) view2.getTag();
            } else {
                view2 = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.cKV = view2.findViewById(d.g.divider_view);
                view2.setTag(aVar2);
            }
            this.mContext.getLayoutMode().u(view2);
        }
        return view2;
    }

    public void I(ArrayList<i> arrayList) {
        this.cUG = arrayList;
    }

    public void a(p pVar) {
        this.cUH = pVar;
    }

    /* loaded from: classes3.dex */
    public class b {
        RelativeLayout cUK;
        BawuMemberInfoView cUL;
        BawuMemberInfoView cUM;
        BawuManagerApplyInfoView cUN;
        BawuManagerApplyInfoView cUO;

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
        View cKV;

        public a() {
        }
    }
}
