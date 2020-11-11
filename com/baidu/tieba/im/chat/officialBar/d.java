package com.baidu.tieba.im.chat.officialBar;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes26.dex */
public class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> aiK = new ArrayList<>();
    private c jXY;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes26.dex */
    public interface c {
        void a(View view, Object obj, int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbPageContext<?> tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.jXY = cVar;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.aiK.clear();
            this.aiK.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.aiK != null && this.aiK.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.aiK.get(i);
            if ((viewHolder instanceof b) && (aVar instanceof a)) {
                ((b) viewHolder).b(aVar);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.aiK == null) {
            return 0;
        }
        return this.aiK.size();
    }

    /* loaded from: classes26.dex */
    class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        private BarImageView jYa;
        private View jYb;
        private a jYc;
        private TextView jmj;

        b(View view) {
            super(view);
            this.jYa = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.jmj = (TextView) view.findViewById(R.id.official_bar_name);
            this.jYb = view.findViewById(R.id.official_bar_feed_red_dot);
            this.jYa.setShowOval(true);
            this.jYa.setPlaceHolder(2);
            this.jYa.setShowOuterBorder(false);
            this.jYa.setShowInnerBorder(true);
            this.jYa.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        void b(com.baidu.tbadk.mvc.b.a aVar) {
            this.jYc = (a) aVar;
            ap.setViewTextColor(this.jmj, R.color.cp_cont_b);
            ap.setBackgroundResource(this.jYb, R.drawable.icon_official_bar_red_dot);
            this.jYa.setStrokeColorResId(R.color.cp_border_a);
            this.jYa.startLoad(this.jYc.cPd(), 10, false);
            if (at.getChineseAndEnglishLength(this.jYc.cJa()) <= 10) {
                this.jmj.setText(this.jYc.cJa());
            } else {
                this.jmj.setText(at.cutChineseAndEnglishWithSuffix(this.jYc.cJa(), 8, StringHelper.STRING_MORE));
            }
            this.jYa.setOnClickListener(this);
            if (this.jYc.getUnReadCount() > 0 && (this.jYc.cPe() <= 0 || System.currentTimeMillis() - this.jYc.cPe() < 864000000)) {
                this.jYb.setVisibility(0);
            } else {
                this.jYb.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.jYb.setVisibility(8);
            if (d.this.jXY != null) {
                d.this.jXY.a(view, this.jYc, getAdapterPosition(), getItemId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public static class a implements com.baidu.tbadk.mvc.b.a {
        private long cRD;
        private long groupId;
        private String jXZ;
        private String jxd;
        private int unReadCount;
        private int userType;

        String cPd() {
            return this.jXZ;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String cJa() {
            return this.jxd;
        }

        int getUnReadCount() {
            return this.unReadCount;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void Me(String str) {
            this.jXZ = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void Mf(String str) {
            this.jxd = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setUnReadCount(int i) {
            this.unReadCount = i;
        }

        public void setGroupId(long j) {
            this.groupId = j;
        }

        public void setUserType(int i) {
            this.userType = i;
        }

        public long getGroupId() {
            return this.groupId;
        }

        public long cPe() {
            return this.cRD;
        }

        public void ge(long j) {
            this.cRD = j;
        }
    }
}
