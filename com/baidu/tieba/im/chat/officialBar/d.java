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
    private ArrayList<com.baidu.tbadk.mvc.b.a> aiJ = new ArrayList<>();
    private c jFC;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes26.dex */
    public interface c {
        void a(View view, Object obj, int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbPageContext<?> tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.jFC = cVar;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.aiJ.clear();
            this.aiJ.addAll(arrayList);
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
        if (this.aiJ != null && this.aiJ.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.aiJ.get(i);
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
        if (this.aiJ == null) {
            return 0;
        }
        return this.aiJ.size();
    }

    /* loaded from: classes26.dex */
    class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView iTP;
        private BarImageView jFE;
        private View jFF;
        private a jFG;

        b(View view) {
            super(view);
            this.jFE = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.iTP = (TextView) view.findViewById(R.id.official_bar_name);
            this.jFF = view.findViewById(R.id.official_bar_feed_red_dot);
            this.jFE.setShowOval(true);
            this.jFE.setPlaceHolder(2);
            this.jFE.setShowOuterBorder(false);
            this.jFE.setShowInnerBorder(true);
            this.jFE.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        void b(com.baidu.tbadk.mvc.b.a aVar) {
            this.jFG = (a) aVar;
            ap.setViewTextColor(this.iTP, R.color.cp_cont_b);
            ap.setBackgroundResource(this.jFF, R.drawable.icon_official_bar_red_dot);
            this.jFE.setStrokeColorResId(R.color.cp_border_a);
            this.jFE.startLoad(this.jFG.cJv(), 10, false);
            if (at.getChineseAndEnglishLength(this.jFG.cDs()) <= 10) {
                this.iTP.setText(this.jFG.cDs());
            } else {
                this.iTP.setText(at.cutChineseAndEnglishWithSuffix(this.jFG.cDs(), 8, StringHelper.STRING_MORE));
            }
            this.jFE.setOnClickListener(this);
            if (this.jFG.getUnReadCount() > 0 && (this.jFG.cJw() <= 0 || System.currentTimeMillis() - this.jFG.cJw() < 864000000)) {
                this.jFF.setVisibility(0);
            } else {
                this.jFF.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.jFF.setVisibility(8);
            if (d.this.jFC != null) {
                d.this.jFC.a(view, this.jFG, getAdapterPosition(), getItemId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public static class a implements com.baidu.tbadk.mvc.b.a {
        private long cDo;
        private long groupId;
        private String jFD;
        private String jeI;
        private int unReadCount;
        private int userType;

        String cJv() {
            return this.jFD;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String cDs() {
            return this.jeI;
        }

        int getUnReadCount() {
            return this.unReadCount;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void Lp(String str) {
            this.jFD = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void Lq(String str) {
            this.jeI = str;
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

        public long cJw() {
            return this.cDo;
        }

        public void fH(long j) {
            this.cDo = j;
        }
    }
}
