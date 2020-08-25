package com.baidu.tieba.im.creategroup;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class i implements o {
    HeadImageView jkA;
    ImageView jkB;
    TextView jkC;
    private com.baidu.adp.widget.ImageView.a jkD = null;
    private a jkE = null;
    CreateGroupStepActivity jka;
    private int jke;
    private int mIndex;
    private int mStep;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.jka = null;
        this.mView = null;
        this.jkA = null;
        this.jkB = null;
        this.jkC = null;
        this.jka = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.jkB = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.jkA = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.jkC = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.jke = i3;
    }

    public void cCT() {
        if (this.jkE != null) {
            this.jkE.cancel();
        }
        this.jkD = null;
        this.jkE = new a();
        this.jkE.execute(new Object[0]);
    }

    public ImageView cCU() {
        return this.jkB;
    }

    public TextView cCV() {
        return this.jkC;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cCE() {
        this.jkB.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cCF() {
        this.jka.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jka.getLayoutMode().onModeChanged(this.mView);
        this.jkA.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.n.getImage(null, TbConfig.GROUP_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (bitmap != null) {
                i.this.jkA.setVisibility(0);
                i.this.jkD = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.jkD.drawImageTo(i.this.jkA);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.jka.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cCH() {
        if (this.mIndex != this.jke) {
            return this.jka.getPageContext().getString(R.string.next_step);
        }
        return this.jka.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cCI() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cCy() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cCJ() {
        return true;
    }
}
