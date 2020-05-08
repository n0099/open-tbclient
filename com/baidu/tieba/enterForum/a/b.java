package com.baidu.tieba.enterForum.a;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.k;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> caH = new ArrayList<>();
    private InterfaceC0550b gzj;
    private boolean gzk;
    private int mFrom;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0550b {
        void a(View view, k kVar);

        void bN(View view);
    }

    public b(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.mFrom = i;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.caH.clear();
            this.caH.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_horizontal_item_view, (ViewGroup) null);
        return i == 2 ? new a(inflate) : new c(inflate);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.caH != null && this.caH.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.caH.get(i);
            if ((viewHolder instanceof a) && (aVar instanceof com.baidu.tieba.enterForum.data.a)) {
                ((a) viewHolder).a((com.baidu.tieba.enterForum.data.a) aVar);
            } else if ((viewHolder instanceof c) && (aVar instanceof k)) {
                ((c) viewHolder).a((k) aVar);
                an anVar = new an("c13642");
                anVar.t("uid", TbadkApplication.getCurrentAccountId());
                anVar.t("fid", ((k) aVar).getForumId());
                if (this.mFrom == 0) {
                    anVar.af("obj_locate", 1);
                    anVar.af("obj_type", this.gzk ? 3 : 1);
                } else if (this.mFrom == 1) {
                    anVar.af("obj_locate", 2);
                    anVar.cI("resource_id", this.mTabName);
                }
                TiebaStatic.log(anVar);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.caH.get(i) instanceof k) {
            return 1;
        }
        if (this.caH.get(i) instanceof com.baidu.tieba.enterForum.data.a) {
            return 2;
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.caH == null) {
            return 0;
        }
        return this.caH.size();
    }

    public void a(InterfaceC0550b interfaceC0550b) {
        this.gzj = interfaceC0550b;
    }

    /* loaded from: classes9.dex */
    class c extends RecyclerView.ViewHolder {
        private TextView aDO;
        private String attention;
        private TextView dHD;
        private BarImageView gzl;
        private ImageView gzm;
        private k gzq;
        private View mRootView;

        public c(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.gzl = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.gzm = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.dHD = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.aDO = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.gzj != null) {
                        b.this.gzj.a(view2, c.this.gzq);
                    }
                }
            });
        }

        public void a(k kVar) {
            if (kVar != null) {
                this.gzq = kVar;
                this.gzl.setShowOval(true);
                this.gzl.setShowOuterBorder(false);
                this.gzl.setShowInnerBorder(true);
                this.gzl.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.gzl.setStrokeColorResId(R.color.cp_border_a);
                this.gzm.setVisibility(8);
                this.gzl.setVisibility(0);
                this.gzl.startLoad(kVar.getAvatar(), 10, false);
                if (aq.getChineseAndEnglishLength(kVar.getForumName()) <= 10) {
                    this.dHD.setText(kVar.getForumName());
                } else {
                    this.dHD.setText(aq.cutChineseAndEnglishWithSuffix(kVar.getForumName(), 8, StringHelper.STRING_MORE));
                }
                this.aDO.setText(this.attention + " " + aq.cl(kVar.bHU()));
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            am.setViewTextColor(this.dHD, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.aDO, (int) R.color.cp_cont_d);
        }
    }

    /* loaded from: classes9.dex */
    class a extends RecyclerView.ViewHolder {
        private TextView aDO;
        private String attention;
        private TextView dHD;
        private BarImageView gzl;
        private ImageView gzm;
        private View mRootView;

        public a(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.gzl = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.gzm = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.dHD = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.aDO = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.gzj != null) {
                        b.this.gzj.bN(view2);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.enterForum.data.a aVar) {
            if (aVar != null) {
                this.gzm.setVisibility(0);
                this.gzl.setVisibility(8);
                SvgManager.aOR().a(this.gzm, R.drawable.ic_icon_pure_square28, (SvgManager.SvgResourceStateType) null);
                this.dHD.setText(R.string.forum_square_title);
                this.aDO.setText(R.string.forum_square_desc_1);
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            am.setViewTextColor(this.dHD, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.aDO, (int) R.color.cp_cont_d);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setHasLikeForum(boolean z) {
        this.gzk = z;
    }
}
