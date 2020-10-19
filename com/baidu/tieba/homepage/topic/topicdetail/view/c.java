package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class c extends m {
    private EditText fbI;

    public c(Context context) {
        super(context, (String) null, 29);
        this.eZU = false;
        this.eZT = 3;
        this.eYZ = new TopicDetaiInputContainer(context);
        this.fbI = ((TopicDetaiInputContainer) this.eYZ).getInputView();
        ((TopicDetaiInputContainer) this.eYZ).setHint(context.getString(R.string.say_your_point));
        this.eZV = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.fbI;
    }
}
